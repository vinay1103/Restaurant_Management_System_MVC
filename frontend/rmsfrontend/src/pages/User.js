import axios from "axios";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import NavBar from "../components/NavBar";
import SideBar from "../components/SideBar";
import { URL } from "../config";
import '../css/User.css'

const User=()=>
{

    const [user,setUser]=useState([])


    const [userId, setUserId ]= useState(0);
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [phone, setPhone] = useState("");
    const [password, setPassword] =useState("");
    
    const [role, setRole] = useState("")
    const currentUserId= sessionStorage['userId'] 

const getData=()=>
{
    axios.get(`${URL}/users`).then((response)=>
    {

        const result = response.data;
        setUser(result.data)

    })

}

const addData=()=>
{

    if(name.length===0||email.length===0||phone.length===0||password.length===0||role.length===0)
    {
        toast.warning("Please fill all Details")
    }
    else
    {
        const data = new FormData()
        data.append('name',name)
        data.append('email',email)
        data.append('phone',phone)
        data.append('password',password)
        data.append('role',role)
       
            
        axios.post(`${URL}/users`,data).then((response)=>
        {
        const result = response.data
        if (result['status'] == 'success') {
            toast.success('User Added Successfully')
            getData()

        }
        else
        {
            toast.error(result['error'])
        }


        })

  
    }

}

const deleteData=( id)=>
{
    axios.delete(`${URL}/users/${id}`).then((response)=>
    {
 
            const result = response.data;
        getData()
    })
}

const editData=(id, name,email,phone)=>
{
    setUserId(id)
    setName(name)
    setEmail(email)
    setPhone(phone)
}

const updateData=()=>
{
    const data = new FormData()
    data.append('name',name)
    data.append('email',email)
    data.append('phone',phone)
   if(password.length!=0)
   {
    data.append('password',password)
   }
  
   if(role.length!=0)
   {
    data.append('role',role)
   }
  
       
        
   axios.put(`${URL}/users/${userId}`,data).then((response)=>
   {
    const result = response.data
    if (result['status'] == 'success') {
        toast.success('Data Updated Successfully')
        getData()

    }
    else
    {
      toast.error(result['error'])
    }


   })
}

const updateStatus=(status,id)=>
{

    if(status=="Enabled")
    {
        const body ={
            "currentStatus": "Disabled"
        }
        axios.patch(`${URL}/users/${id}`,body).then((response)=>
        {
 
        const result = response.data;
        getData()
        })
    }
    else
    {
        const body ={
            "currentStatus": "Enabled"
        }
      
        axios.patch(`${URL}/users/${id}`,body).then((response)=>
        {
 
        const result = response.data;
        getData()
 
        })
    }
}

    useEffect(getData,[])

   
    return <SideBar>
        <div className="title"><NavBar ></NavBar>

        
       <div className="modal fade" id="addModal" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div className="modal-dialog">
    <div className="modal-content">
      <div className="modal-header">
        <h5 className="modal-title fs-3 fw-bold" id="exampleModalLabel">Add User</h5>
        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div className="modal-body">
       <form >
       <div class="form-outline mb-4">
<label  class="form-label" for="typeEmailX-2">Name</label>
             <input onChange={((e)=>{setName(e.target.value)})} type="text"  class="form-control"  />
            
           </div>
<div class="form-outline mb-4">
<label  class="form-label" for="typeEmailX-2">Email</label>
             <input  onChange={(e)=>{setEmail(e.target.value)}}  type="email"  class="form-control " />
            
           </div>
           <div class="form-outline mb-4">
           <label class="form-label" for="typePasswordX-2">Phone</label>
             <input  onChange={(e)=>{setPhone(e.target.value)}}  type="text"  class="form-control"   />
             
           </div>
           <div class="form-outline mb-4">
           <label class="form-label" for="typePasswordX-2">Password</label>
             <input  onChange={(e)=>{setPassword(e.target.value)}} type="password"  class="form-control"   />
             
           </div>
           <div class="form-outline mb-4">
           <label style={{marginRight:"5px",marginTop:"5px"}} className="fs-5">Role: </label>
           <select   className="form-select" onChange={(e)=>{setRole(e.target.value)}} >
           <option disabled selected value> -- select a role -- </option>
           <option value="manager">Manager</option>
       <option value="waiter">Waiter</option>
       <option value="chef">Chef</option>
       <option value="cashier">Cashier</option>
         
           
           
          </select>
           </div>
          
       </form>
      </div>
      <div className="modal-footer">
        <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button onClick={addData}  type="button" className="btn btn-primary" data-bs-dismiss="modal" >Add</button>
      </div>
    </div>
  </div>
</div>

<div className="modal fade" id="editModal" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div className="modal-dialog">
    <div className="modal-content">
      <div className="modal-header">
        <h5 className="modal-title fs-3 fw-bold" id="exampleModalLabel">Edit User</h5>
        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div className="modal-body">
      <form >
       <div class="form-outline mb-4">
<label  class="form-label" for="typeEmailX-2">Name</label>
             <input  value={name} onChange={((e)=>{setName(e.target.value)})} type="text"  class="form-control"  />
            
           </div>
<div class="form-outline mb-4">
<label  class="form-label" for="typeEmailX-2">Email</label>
             <input  value={email} onChange={(e)=>{setEmail(e.target.value)}}  type="email"  class="form-control " />
            
           </div>
           <div class="form-outline mb-4">
           <label class="form-label" for="typePasswordX-2">Phone</label>
             <input  value={phone} onChange={(e)=>{setPhone(e.target.value)}}  type="text"  class="form-control"   />
             
           </div>
           <div class="form-outline mb-4">
           <label class="form-label" for="typePasswordX-2">Password</label>
             <input  onChange={(e)=>{setPassword(e.target.value)}} type="password"  class="form-control"   />
             
           </div>
           <div class="form-outline mb-4">
           <label style={{marginRight:"5px",marginTop:"5px"}} className="fs-5">Role: </label>
           <select   className="form-select" onChange={(e)=>{setRole(e.target.value)}} >
           <option disabled selected value> -- select a role -- </option>
           <option value="manager">Manager</option>
       <option value="waiter">Waiter</option>
       <option value="chef">Chef</option>
       <option value="cashier">Cashier</option>
      
           
           
          </select>
           </div>
           
       </form>
      </div>
      <div className="modal-footer">
        <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button onClick={updateData} type="button" className="btn btn-primary" data-bs-dismiss="modal" >Save changes</button>
      </div>
    </div>
  </div>
</div>



        <div className="mainelementusr">
        <h2 style={{textAlign:"center"}}>User Details</h2>
<hr />

<button  on data-bs-toggle="modal" data-bs-target="#addModal" style={{marginLeft:"40px",marginBottom:"10px"}} className="btn btn-success btn-lg">Add</button>
        <div className="subelementusr">
            
<table id="usrtableid" style={{textAlign:"center"}}  class="table table-bordered table-hover  mb-0">
    <thead>
      <tr className="tablerowusr">
       
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Contact No.</th>
        <th scope="col">Role</th>
        <th scope="col">Created Date</th>
        <th scope="col">Status</th>
        <th scope="col">Action</th>
      </tr>
    </thead> 

    <tbody>

    {
     
     user.map((usr)=>
      {
        
          return(
            <tr key={usr.userId}>
           
            <th scope="col">{usr.name} </th>
            <td scope="col">{usr.email} </td>
            <td scope="col">{usr.phone} </td>
            <td scope="col">{usr.role} </td>
            <td scope="col">{usr.createdDate} </td>
            <td>
                {usr.currentStatus=="Enabled" ? (currentUserId!=usr.userId?<button onClick={updateStatus.bind(this,usr.currentStatus,usr.userId)} className="btn btn-success btn-md">{usr.currentStatus}</button>:<button  disabled onClick={updateStatus.bind(this,usr.currentStatus,usr.userId)} className="btn btn-success btn-md">{usr.currentStatus}</button>): <button onClick={updateStatus.bind(this,usr.currentStatus,usr.userId)}  className="btn btn-danger btn-md">{usr.currentStatus}</button>}
               
                
                </td>
            <td><button style={{marginRight:"20px"}} className="btn btn-info btn-md"  data-bs-toggle="modal" data-bs-target="#editModal" onClick={editData.bind(this,usr.userId,usr.name,usr.email,usr.phone)}>Edit</button>
          {
            currentUserId!=usr.userId&&  <button onClick={deleteData.bind(this,usr.userId)} className="btn btn-warning btn-md">Delete</button>
          }
          </td>
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




export default User;