import axios from "axios";
import { useEffect, useState } from "react";
import NavBar from "../components/NavBar";
import SideBar from "../components/SideBar";
import { URL } from "../config";
import '../css/Bill.css'

const Bill=()=>
{

  const [billData,setBillData]=useState([])
  const[billId,setBillId]=useState(0)
  const[orderId,setOrderId]=useState(0)
  const[tableId,setTableId]=useState(0)
  const [billById,setBillById]=useState({})
  const[orderItemData,setOrderItemData]=useState([])
  const[total,setTotal]=useState(0.0)
  const[totalTax,setTotalTax]=useState(0.0)
  const[amount,setAmount]=useState(0.0)
  const[discount,setDiscount]=useState(0.0)
  const[discountValue,setDiscountValue]=useState(0.0)
  const[taxValue,setTaxValue]=useState(0.0)
  const[paymentMethod,setPaymentMethod]=useState("")
  
  const userId= sessionStorage['userId']

  const getData=()=>
  {
      axios.get(`${URL}/bill`).then((response)=>
      {
  
          const result = response.data;
          setBillData(result.data)
  
      })
  
  }

  const getBillById=(id,orderId,tableid)=>
  {

    setBillId(id)
    setOrderId(orderId)
    setTableId(tableid)
      axios.get(`${URL}/bill/${id}`).then((response)=>
      {
  
          const result = response.data;
        setBillById(result.data)
        getOrderItem(orderId)
       

  
      })
  
  }


  const sumOfAmount=(tax)=>
  {
    var table = document.getElementById("ordtableid"),sumVal=0
    for(var i = 1; i < table.rows.length-5; i++)
    {
  
        sumVal = sumVal + parseInt(table.rows[i].cells[3].innerHTML);
    }
   

      const taxval=(tax/100)*sumVal
      setAmount(sumVal+taxval)
      setTotalTax(sumVal+taxval)
      setTotal(sumVal)
      setTaxValue(taxval)
  }

  const getOrderItem=(orderId)=>
  {
    
    axios.get(`${URL}/item/${orderId}`).then((response)=>
      {
  
          const result = response.data;
          setOrderItemData(result.data)
  
      })
  }
  const deleteBill=(id)=>
  {

      axios.delete(`${URL}/bill/${id}`).then((response)=>
      {
  
          const result = response.data;
          getData()
  
      })
  
  }

  const addBill=()=>
  {
  
    const body={
      "billCashierId":userId,
      "discount":discount,
      "billAmount":amount,
       "billTotal": totalTax,
      "billPaymentMethod":paymentMethod,
      "billStatus":"Completed"
  }

  axios.put(`${URL}/bill/${billId}`,body).then((response)=>
  {

      const result = response.data;
      updateOrderStatus()
      updateTableStatus()
      getData()

  })

    setTotal(0)
  
  }


  const closeBill=()=>
  {
    setTotal(0)
  }


  const updateOrderStatus=()=>
  {

    const body={
      "orderStatus":"Completed"
     
  }
    axios.patch(`${URL}/orders/${orderId}`,body).then((response)=>
  {

      const result = response.data;

  })
  }

  const updateTableStatus=()=>
  {

    const body={
      "waiterId": 0,
      "tableStatus": "Not Booked"
  }
    axios.put(`${URL}/tables/assign/${tableId}`,body).then((response)=>
  {

      const result = response.data;
  })
  }


  const calculateAmount=(discount)=>
  {
    if(discount.length==0)
    {
      setAmount(total+taxValue)
      setDiscount(0)
      setDiscountValue(0)
    }
    else
    {
      const value=(discount/100)*total
      setDiscountValue(value)
      setAmount(total-value+taxValue)
      setDiscount(discount)
    }
  }


  useEffect(getData,[])


    return <SideBar>
        <div className="title"><NavBar></NavBar>
        <div className="modal fade " id="addModal" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div className="modal-dialog modal-lg">
    <div className="modal-content">
      <div className="modal-header">
        <h5 className="modal-title fs-3 fw-bold" id="exampleModalLabel">Bill</h5>
        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div className="modal-body">
     <table id="ordtableid" style={{textAlign:"center"}}  class="table table-bordered table-hover  mb-0">
    <thead>
      <tr className="tableroword">
        <th scope="col">Product Name</th>
        <th scope="col">Quantity</th>
        <th scope="col">Rate</th>
        <th style={{width:"250px"}} scope="col">Amount</th>
       
      </tr>
    </thead> 

    <tbody>

            {
              orderItemData.map((oitem)=>
              {
                return(
                  <tr key={oitem.orderItemId}>
                  <td scope="col">{oitem.orderItemName} </td>
                  <td  scope="col">{oitem.orderItemQuantity}  </td>
                  <td scope="col">{oitem.orderItemRate} </td>
                  <td scope="col">{oitem.orderItemAmount} </td>
                  </tr>
                )
              })
            }
         {billById.billTotal==0? 
          <tr>
           <td colspan="3"><button onClick={sumOfAmount.bind(this,billById.taxAndCharge)}  type="button" className="btn btn-outline-info btn-sm"  >Calculate Total</button></td>
           <td>Rs. {total}</td>
         </tr>
         
         : 
         <tr>
         <td colspan="3">Total</td>
         <td>Rs. {billById.billTotal}</td>
       </tr>
         }
         {billById.billTotal==0&&
          <tr>
           <td colspan="3">Tax({billById.taxAndCharge}%)</td>
           <td>Rs. {taxValue}</td>
         </tr> 
         }
         
          {billById.billTotal==0? 
          <tr>
           <td colspan="3">
           <div class="row">
           <div style={{marginLeft:"150px"}} class="col-auto">
           Discount(%) 
           </div >
           <div style={{marginLeft:"10px"}} class="col-auto">
           <input style={{display:"inline"}} type="number" className="form-control"
           onChange={(e)=>
          {
            calculateAmount(e.target.value)
          }}
           ></input>
             </div>
           </div>
           </td>
           <td>Rs. {discountValue}</td>
         </tr>
         
         : 
         <tr>
         <td colspan="3">Discount</td>
         <td>{billById.discount} %</td>
       </tr>
         }
{billById.billTotal==0? 
          <tr>
           <td colspan="3">Amount</td>
           <td>Rs. {amount}</td>
         </tr>
         
         : 
         <tr>
         <td colspan="3">Amount</td>
         <td>Rs. {billById.billAmount}</td>
       </tr>
         }
            {billById.billTotal==0? 
          <tr>
           <td colspan="3">Payment Method</td>
           <td>
           <select className="form-select" onChange={(e)=>{setPaymentMethod(e.target.value)}} >
       <option disabled selected value>-Choose Payment Method-</option>
       <option  value="Card"> Card</option>
       <option  value="Cash">Cash </option>
       <option  value="UPI"> UPI </option>
       <option  value="Other"> Other </option>
          </select>
           </td>
         </tr>
         : 
         <tr>
         <td colspan="3">Payment Method</td>
         <td>{billById.billPaymentMethod}</td>
       </tr>
         }
    </tbody>
    </table>
      </div>
      <div className="modal-footer">
        <button onClick={closeBill} type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
       {billById.billStatus=="InProcess"&& <button onClick={addBill}  type="button" className="btn btn-primary" data-bs-dismiss="modal" >Paid</button>}
      </div>
    </div>
  </div>
</div>
        <div className="mainelementbill">
        <h2 style={{textAlign:"center"}}>Bill Details</h2>
<hr />

        <div className="subelementbill">
<table id="billtableid" style={{textAlign:"center"}}  class="table table-bordered table-hover  mb-0">
    <thead>
      <tr className="tablerowbill">
      <th scope="col">Table Name</th>
        <th scope="col">Order No.</th>
        <th scope="col">Bill Date</th>
        <th scope="col">Manager Name</th>
        <th scope="col">Cashier Name</th>
        <th scope="col">Status</th>
        <th scope="col">Action</th>
      </tr>
    </thead> 

    <tbody>
{
  billData.map((bill)=>
  {
      return(
        <tr key={bill.billId}>
        <td scope="col">{bill.tableName} </td>
        <td scope="col">{bill.billOrderId} </td>
        <td scope="col">{bill.billDate} </td>
        <td scope="col">{bill.waiterName} </td>
        <td scope="col">{bill.billCashierName} </td>
        <td scope="col">{bill.billStatus} </td>
        <td><button onClick={getBillById.bind(this,bill.billId,bill.billOrderId,bill.tableId)} style={{marginRight:"20px"}} className="btn btn-info btn-md" data-bs-toggle="modal" data-bs-target="#addModal"  >View</button>
            <button onClick={deleteBill.bind(this,bill.billId)}  className="btn btn-warning btn-md">Delete</button></td>
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

export default Bill;