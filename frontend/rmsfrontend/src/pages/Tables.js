import axios from "axios";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import NavBar from "../components/NavBar";
import SideBar from "../components/SideBar";
import { URL } from "../config";
import '../css/Table.css'

const Tables=()=>
{

    const [id, setId] = useState(0);
    const [name, setName] = useState("");
    const [capacity, setCapacity] = useState(0);
    const [tableData,setTableData]=useState([]);
    const [userId, setUserId] = useState(0);
    const [userData,setUserData]=useState([]);
const getData=()=>
{
    axios.get(`${URL}/tables`).then((response)=>
    {

        const result = response.data;
        setTableData(result.data)

    })

}

const addData=()=>
{

    if(name.length==0||capacity.length==0)
    {
        toast.warning("Enter Data")
    }
    else
    {
                const body ={
                    "tableName": name,
                    "tableCapacity": capacity
            }


             axios.post(`${URL}/tables`,body).then((response)=>
                    {
                        const result = response.data;
                        getData()
                    })
    }
}

const deleteData=( id)=>
{
            axios.delete(`${URL}/tables/${id}`).then((response)=>
            {
        
                    const result = response.data;
                getData()
            })
}

const editData=( name,id,capacity)=>
{
    setId(id)
    setName(name)
    setCapacity(capacity)
}


const updateData=()=>
{

    const body ={
        "tableName": name,
        "tableCapacity": capacity
}
  
    axios.put(`${URL}/tables/${id}`,body).then((response)=>
    {
 
        const result = response.data;
        getData()
    })
}

const editStatus=(id)=>
{
    setId(id)
    axios.get(`${URL}/users/role/waiter`).then((response)=>
    {

        const result = response.data;
        setUserData(result.data)

    })

}
const updateStatus=()=>
{
    const body ={
        "waiterId": userId,
        "tableStatus": "Booked"
            }

            axios.put(`${URL}/tables/assign/${id}`,body).then((response)=>
            {
         
                const result = response.data;
                getData()
            })

}

    useEffect(getData,[])

   
    return <SideBar>
        <div className="title"><NavBar ></NavBar>

        
      <div className="modal fade" id="addModal" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div className="modal-dialog">
    <div className="modal-content">
      <div className="modal-header">
        <h5 className="modal-title fs-3 fw-bold" id="exampleModalLabel">Add Table</h5>
        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div className="modal-body">
       <form >
       <label style={{marginRight:"5px"}} className="fs-5">Name: </label>
       <input   onChange={(e)=>{setName(e.target.value)}} className="form-control" type="text" />
       <label style={{marginRight:"5px"}} className="fs-5">Capacity: </label>
       <input   onChange={(e)=>{setCapacity(e.target.value)}} className="form-control" type="text" />

       </form>
      </div>
      <div className="modal-footer">
        <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button onClick={addData}  type="button" className="btn btn-primary" data-bs-dismiss="modal" >Add</button>
      </div>
    </div>
  </div>
</div>

<div className="modal fade" id="statusModal" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div className="modal-dialog">
    <div className="modal-content">
      <div className="modal-header">
        <h5 className="modal-title fs-3 fw-bold" id="exampleModalLabel">Assign Waiter</h5>
        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div className="modal-body">
      <label style={{marginRight:"5px",marginTop:"5px"}} className="fs-5">Waiter: </label>
       <select className="form-select" onChange={(e)=>{setUserId(e.target.value)}} >
       <option disabled selected value> -- Choose Waiter -- </option>
           {
               userData.map((usr)=>
               {
               return  <option value={usr.userId}>{usr.name}</option>
               })
           }
          
          </select>
      </div>
      <div className="modal-footer">
        <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button onClick={updateStatus}  type="button" className="btn btn-primary" data-bs-dismiss="modal" >Assign</button>
      </div>
    </div>
  </div>
</div>




<div className="modal fade" id="editModal" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div className="modal-dialog">
    <div className="modal-content">
      <div className="modal-header">
        <h5 className="modal-title fs-3 fw-bold" id="exampleModalLabel">Edit Table</h5>
        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div className="modal-body">
       <form  method="post">
       <label  className="fs-5" >Name: </label>
       <input  value={name}  onChange={((e)=>{setName(e.target.value)})} type="text" className="form-control" />
       <label  className="fs-5" >Capacity: </label>
       <input  value={capacity}  onChange={((e)=>{setCapacity(e.target.value)})} type="text" className="form-control" />

       </form>
      </div>
      <div className="modal-footer">
        <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button onClick={updateData} type="button" className="btn btn-primary" data-bs-dismiss="modal" >Save changes</button>
      </div>
    </div>
  </div>
</div>












        <div className="mainelementtab">
        <h2 style={{textAlign:"center"}}>Table Details</h2>
<hr />

<button data-bs-toggle="modal" data-bs-target="#addModal" style={{marginLeft:"40px",marginBottom:"10px"}} className="btn btn-success btn-lg">Add</button>
        <div className="subelementtab">




<table id="tabtableid" style={{textAlign:"center"}}  class="table table-bordered table-hover  mb-0">
    <thead>
      <tr className="tablerowtab">
        <th scope="col">Table Name</th>
        <th scope="col">Capacity</th>
        <th scope="col">Status</th>
        <th scope="col">Waiter Name</th>
        <th scope="col">Action</th>
      </tr>
    </thead> 

    <tbody>

    {
     
     tableData.map((tab)=>
      {
        
          return(
            <tr key={tab.tableId}>
            <th scope="col">{tab.tableName} </th>
            <td>{tab.tableCapacity}</td>
            <td>
                {tab.tableStatus=="Booked" ? <button onClick={editStatus.bind(this,tab.tableId)} className="btn btn-success btn-md" data-bs-toggle="modal" data-bs-target="#statusModal">{tab.tableStatus}</button>: <button onClick={editStatus.bind(this,tab.tableId)}  className="btn btn-danger btn-md" data-bs-toggle="modal" data-bs-target="#statusModal">{tab.tableStatus}</button>}
               
                
                </td>
                <td>{tab.waiterName}</td>
            <td><button style={{marginRight:"20px"}} className="btn btn-info btn-md"  data-bs-toggle="modal" data-bs-target="#editModal" onClick={editData.bind(this,tab.tableName,tab.tableId,tab.tableCapacity)}>Edit</button>
            <button onClick={deleteData.bind(this,tab.tableId)} className="btn btn-warning btn-md">Delete</button></td>
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

export default Tables;