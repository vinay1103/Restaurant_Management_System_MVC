import axios from "axios";
import { useEffect, useState } from "react";
import NavBar from "../components/NavBar";
import SideBar from "../components/SideBar";
import { URL } from "../config";
import '../css/OrderChef.css'
const OrdersChef=()=>
{
const role= sessionStorage['role']
const userId= sessionStorage['userId']

  const[orderId,setOrderId]=useState(0)
  const[orderItemData,setOrderItemData]=useState([])
  const[orderData,setOrderData]=useState([])


  const getAllOrder=()=>
  {
    
    

      axios.get(`${URL}/orders/Pending`).then((response)=>
      {
  
          const result = response.data;
        setOrderData(result.data)
        
      })



  }

  const getOrderItem=(orderId)=>
  {

    setOrderId(orderId)
      axios.get(`${URL}/item/${orderId}`).then((response)=>
      {
  
          const result = response.data;
          setOrderItemData(result.data)
  
      })
  }



  const updateOrder=()=>
  {
   
      const body =
      {
        "orderStatus":"Completed"
       
    }
      axios.patch(`${URL}/orders/${orderId}`,body).then((response)=>
      {
  
      
        getAllOrder()
      })

   
     
  }
  

  

  


  useEffect(getAllOrder,[])


    return <SideBar>
        <div className="title"><NavBar></NavBar>
    
        <div className="modal fade " id="addModal" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div className="modal-dialog modal-lg">
    <div className="modal-content">
      <div className="modal-header">
        <h5  className="modal-title fs-3 fw-bold" id="exampleModalLabel">Order Items</h5>
        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div className="modal-body">
      

<table id="ordtableid" style={{textAlign:"center"}}  class="table table-bordered table-hover  mb-0">
    <thead>
      <tr className="tableroword">
      <th scope="col">Sr No.</th>
        <th scope="col">Product Name</th>
        <th scope="col">Quantity</th>
        
       
      </tr>
    </thead> 

    <tbody>

            {
              orderItemData.map((oitem,i)=>
              {
                return(
                  <tr key={oitem.orderItemId}>
                     <th scope="col">{++i} </th>
                  <th scope="col">{oitem.orderItemName} </th>
                  <td  scope="col">{oitem.orderItemQuantity}  </td>
                  </tr>
                )
              })
            }
      
      
    </tbody>
    </table>

  
      </div>
      <div className="modal-footer">
        <button  type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
       <button onClick={updateOrder} type="button" className="btn btn-primary" data-bs-dismiss="modal" >Completed</button>
      </div>
    </div>
  </div>
</div>









        <div className="mainelementordch">
        <h2 style={{textAlign:"center"}}>Order List</h2>
<hr />


     

        <div className="subelementordch">
    

  


<table id="ordchtableid" style={{textAlign:"center"}}  class="table table-bordered table-hover  mb-0">
    <thead>
      <tr className="tablerowordch">
        <th scope="col">Order No.</th>
        <th scope="col">Table Name</th>
        <th scope="col">Status</th>
        <th scope="col">Action</th>
      </tr>
    </thead> 

    <tbody>

            {
              orderData.map((odata)=>
              {
                return(
                  <tr key={odata.orderId}>
                  <th scope="col">{odata.orderId} </th>
                  <td scope="col">{odata.orderTableName} </td>
                  <td scope="col">{odata.orderStatus} </td>
                <td> <button onClick={getOrderItem.bind(this,odata.orderId)} data-bs-toggle="modal" data-bs-target="#addModal" className="btn btn-info btn-md">View</button></td>
                  </tr>
                )
              })
            }


    </tbody>

    </table>
    </div>


        </div>
    </div></SideBar>
};

export default OrdersChef;