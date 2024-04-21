import axios from "axios";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import NavBar from "../components/NavBar";
import SideBar from "../components/SideBar";
import { URL } from "../config";
import '../css/Order.css'
const Orders=()=>
{
const role= sessionStorage['role']
const userId= sessionStorage['userId']

  const[orderId,setOrderId]=useState(0)
  const[tableData,setTableData]=useState([])
  const[orderItemData,setOrderItemData]=useState([])
  const[categoryData,setCategoryData]=useState([])
  const[productData,setProductData]=useState([])
  const[quantity,setQuantity]=useState(0)
  const[productId,setProductId]=useState(0)
  const[flag,setFlag]=useState(false)
const getTableData=()=>
{
    if(role=="manager")
    {
      
        axios.get(`${URL}/tables/active`).then((response)=>
        {
    
            const result = response.data;
            setTableData(result.data)
    
        })
    }
    else
    {
     
      axios.get(`${URL}/tables/${userId}`).then((response)=>
      {
  
          const result = response.data;
          setTableData(result.data)
  
      })
    }

}


  const getOrder=(tableId)=>
  {
      setFlag(true)

      axios.get(`${URL}/orders/find/${tableId}`).then((response)=>
      {
  
          const result = response.data;
          const {orderId} = result['data']

          if(orderId==0)
          {
           addOrder(tableId)
          }
          else
          {
            setOrderId(orderId)
            getOrderItem(orderId)
          }
        
      })



  }

  const getOrderItem=(orderId)=>
  {
     
      axios.get(`${URL}/item/${orderId}`).then((response)=>
      {
  
          const result = response.data;
          setOrderItemData(result.data)
  
      })
  }

  const getCategory=()=>
  {
     
      axios.get(`${URL}/categories/active`).then((response)=>
      {
  
          const result = response.data;
          setCategoryData(result.data)  
      })
  }


  const getProduct=(id)=>
  {
    
    axios.get(`${URL}/products/bycategory/${id}`).then((response)=>
      {
  
          const result = response.data;
          setProductData(result.data)
         
      })
  }
  const addOrder=(tableId)=>
  {

      const body ={
        "orderServicePersonId":userId,
        "orderTableId":tableId
    }
      axios.post(`${URL}/orders`,body).then((response)=>
      {
  
          const result = response.data;
         const{orderId}=result.data
         addBill(orderId)
         setOrderId(orderId)
        getOrderItem(orderId)
  
      })
   
  }


  const addBill=(orderId)=>
  {

      const body={
        "billOrderId":orderId
    }

    
    axios.post(`${URL}/bill`,body).then((response)=>
    {

    })

  }

  const addOrderItem=()=>
  {
     if(productId==0||quantity==0)
     {
       toast.warning("enter all Details")
     }
     else
     {
       const body={
        "orderItemOrderId":orderId,
        "orderItemProductId":productId,
        "orderItemQuantity":quantity
       
       }

       axios.post(`${URL}/item`,body).then((response)=>
       {
   
          getOrderItem(orderId)
       })
     }

     
  }

  const updateOrderItem=(id,quantity)=>
  {
    if(quantity!="")
    {
      const body =
      {
        "orderItemQuantity":quantity
      }
      axios.patch(`${URL}/item/${id}`,body).then((response)=>
      {
         getOrderItem(orderId)
      })

    }
     
  }
  
  const deleteOrderItem=(id)=>
  {

      axios.delete(`${URL}/item/${id}`).then((response)=>
      {
  
         getOrderItem(orderId)
  
      })
  }

  


  useEffect(getTableData,[])


    return <SideBar>
        <div className="title"><NavBar></NavBar>
    
        <div className="modal fade" id="addModal" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div className="modal-dialog">
    <div className="modal-content">
      <div className="modal-header">
        <h5 className="modal-title fs-3 fw-bold" id="exampleModalLabel">Add Order</h5>
        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div className="modal-body">
       <form >
       <label style={{marginRight:"5px",marginTop:"5px"}} className="fs-5">Category: </label>
       <select  className="form-select" onChange={(e)=>{
         getProduct(e.target.value)
       }} >
       <option disabled selected value> -- Choose Category -- </option>
           {
               categoryData.map((cat)=>
               {
               return  <option value={cat.categoryId}>{cat.categoryName}</option>
               })
           }
           
           
          </select>
           

          <label style={{marginRight:"5px",marginTop:"5px"}} className="fs-5">Product: </label>
       <select defaultValue="choose" className="form-select"  onChange={(e)=>{
         setProductId(e.target.value)
       }} >
       <option disabled selected value> -- Choose Product -- </option>
           {
               productData.map((pro)=>
               {
               return  <option value={pro.productId}>{pro.productName}</option>
               })
           }
           
           
          </select>
       <label style={{marginRight:"5px"}} className="fs-5">Quantity: </label>
       <input   onChange={(e)=>{setQuantity(e.target.value)}} className="form-control" type="text" />
    

       </form>
      </div>
      <div className="modal-footer">
        <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button onClick={addOrderItem}  type="button" className="btn btn-primary" data-bs-dismiss="modal" >Add</button>
      </div>
    </div>
  </div>
</div>


        <div className="mainelementord">
        <h2 style={{textAlign:"center"}}>Order Details</h2>
<hr />

        <div className="subelementord">
        <div className="tabselector">
            <h4 style={{marginBottom:"10px"}} className="text-decoration-underline">Choose Table: </h4>
          <div class="row">
    <div class="col">
      <select  className="form-select"  onChange={(e)=>
      {
        getOrder(e.target.value)
      }} >
      <option disabled selected value> -- Choose Table -- </option>
      {
               tableData.map((tab)=>
               {
               return  <option value={tab.tableId}>{tab.tableName}</option>
               })
           }
      </select>
    </div>
    <div class="col">
    {flag?<button  data-bs-toggle="modal" data-bs-target="#addModal"  onClick={getCategory} className="btn btn-success btn-md">Add</button>:
    <button disabled data-bs-toggle="modal" data-bs-target="#addModal"  onClick={getCategory} className="btn btn-success btn-md">Add</button>}
    </div>
</div>

</div>

<table id="ordtableid" style={{textAlign:"center"}}  class="table table-bordered table-hover  mb-0">
    <thead>
      <tr className="tableroword">
        <th scope="col">Product Name</th>
        <th scope="col">Quantity</th>
        <th scope="col">Rate</th>
        <th scope="col">Amount</th>
        <th scope="col">Action</th>
      </tr>
    </thead> 

    <tbody>

            {
              orderItemData.map((oitem)=>
              {
                return(
                  <tr key={oitem.orderItemId}>
                  <td scope="col">{oitem.orderItemName} </td>
                  <td style={{width:"110px"}} scope="col"><input min="1" style={{width:"100px",textAlign:"center"}} className="form-control" defaultValue={oitem.orderItemQuantity} onChange={(e)=>
                  {
                    updateOrderItem(oitem.orderItemId,e.target.value)
                  }} type="number"></input> </td>
                  <td scope="col">{oitem.orderItemRate} </td>
                  <td scope="col">{oitem.orderItemAmount} </td>
                <td> <button onClick={deleteOrderItem.bind(this,oitem.orderItemId)} className="btn btn-warning btn-md">Delete</button></td>
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

export default Orders;