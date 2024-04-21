import axios from "axios";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import NavBar from "../components/NavBar";
import SideBar from "../components/SideBar";
import { URL } from "../config";
import '../css/Home.css'
const Home=()=>
{
const [tableData,setTableData]=useState([]);
const [BillData,setBillData]=useState({});


const getTableData = ()=>
{

  axios.get(`${URL}/tables`).then((response)=>
  {
    const result = response.data
  
    if (result['status'] == 'success') {
      
  
       setTableData(result['data'])
    }
    else
    {
      toast.error("Error occured in getting tables")
    }
  })
}

const getAmountData = ()=>
{

  const url =`${URL}/bill/data`


  axios.get(url).then((response)=>
  {
    const result = response.data
  
    if (result['status'] == 'success') {
      
      setBillData(result['data'])
     
      
    }
    else
    {
      toast.error("Error occured in getting amount data")
    }
  })
}

useEffect(() => {
 getTableData();
getAmountData();
 
}, []) 
  


    return <>  <SideBar><NavBar></NavBar>
   <div className="info1">
   <div className="info2">
     
   <div style={{marginLeft:"0px"}} class="rectangle">
       <p className="textinfo1">Today</p>
       <p className="textinfo2">Rs. {BillData.today}</p>
   </div>
   <div class="rectangle">
   <p className="textinfo1">Yesterday</p>
       <p className="textinfo2">Rs. {BillData.yesterday}</p>
   </div>

   <div class="rectangle">
   <p className="textinfo1">Last 7 Days</p>
       <p className="textinfo2">Rs. {BillData.week}</p>
   </div>
</div>
   </div>
 
   <div className="tableinfo">
  <h3>Table Information</h3>
  <hr></hr>
<div className="tableinfo2">
<div class="table-wrapper-scroll-y my-custom-scrollbar">

  <table class="table table-bordered table-hover mb-0">
    <thead>
      <tr className="tablerow">
        <th scope="col">Name</th>
        <th scope="col">Capacity</th>
        <th scope="col">Status</th>
       
      </tr>
    </thead> 
    <tbody>
   {tableData.map((table,i)=>
   {
     return(

      <tr key={table.tableId}>
      <th scope="row">{table.tableName
    
      }</th>
      <td>{table.tableCapacity}</td>
      <td>{table.tableStatus}</td>
     
    </tr>
     );
   })}
    </tbody>
  </table>

</div>
    
</div>

   </div>
   </SideBar>
    </>
};

export default Home;