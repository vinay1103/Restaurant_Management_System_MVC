import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router';
import { toast } from 'react-toastify';
import NavBar from '../components/NavBar';
import SideBar from '../components/SideBar';
import { URL } from '../config';
import '../css/Setting.css'

const Setting = () => {
    const [userId, setUserId ]= useState(sessionStorage['userId']);
    const [name, setName] = useState(sessionStorage['name']);
    const [email, setEmail] = useState(sessionStorage['email']);
    const [phone, setPhone] = useState(sessionStorage['phone']);
    const [password, setPassword] = useState("");
   
    const navigate = useNavigate()

    const UpdateData =()=>
    {
        const data = new FormData()
        data.append('name',name)
        data.append('email',email)
        data.append('phone',phone)
       if(password.length!=0)
       {
        data.append('password',password)
       }
     
      
           
            
       axios.put(`${URL}/users/${userId}`,data).then((response)=>
       {
        const result = response.data
        if (result['status'] == 'success') {
            toast.success('Data Updated Successfully Login Again')
            sessionStorage['userId'] = 0
            sessionStorage['name'] = null
            sessionStorage['email'] = null
            sessionStorage['phone'] = null
            
            sessionStorage['role'] = null
            sessionStorage['loginStatus'] = 0
            navigate('/login')

        }
        else
        {
            toast.error("Unable to Update Data")
        }


       })
    }

    return <SideBar>
        <div className="title"><NavBar ></NavBar>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h3 class="modal-title" id="exampleModalLabel">Save Changes</h3>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       <h3> Are you sure you want to continue ?</h3>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button onClick={UpdateData} type="button" class="btn btn-primary" data-bs-dismiss="modal">Save changes</button>
      </div>
    </div>
  </div>
</div>






  <div className="mainelement">
  <div className="subelement">
<h2 style={{textAlign:"center"}}>Update Details</h2>
<hr />
<form > 

<div class="form-outline mb-4">
<label  class="form-label" for="typeEmailX-2">Name</label>
             <input  value={name} onChange={((e)=>{setName(e.target.value)})} type="text"  class="form-control form-control-lg" placeholder='abc@gmail.com'  />
            
           </div>
<div class="form-outline mb-4">
<label  class="form-label" for="typeEmailX-2">Email</label>
             <input  value={email} onChange={(e)=>{setEmail(e.target.value)}}  type="email"  class="form-control form-control-lg" placeholder='abc@gmail.com'  />
            
           </div>
           <div class="form-outline mb-4">
           <label class="form-label" for="typePasswordX-2">Phone</label>
             <input  value={phone} onChange={(e)=>{setPhone(e.target.value)}}  type="text"  class="form-control form-control-lg"   />
             
           </div>
           <div class="form-outline mb-4">
           <label class="form-label" for="typePasswordX-2">Password</label>
             <input  onChange={(e)=>{setPassword(e.target.value)}} type="password"  class="form-control form-control-lg"   />
             
           </div>

           
</form>
<button type="button" class="btn btn-primary btn-lg" data-bs-toggle="modal" data-bs-target="#exampleModal">
 Update
</button>
  </div>

  </div>
  
    </div></SideBar>
}

export default Setting