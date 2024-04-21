import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router';
import { toast } from 'react-toastify';
import { URL } from '../config';
import '../css/Login.css'
const Login = () => {

const[email,setEmail]=useState("");
const[password,setPassword]=useState("");
const navigate = useNavigate()

const LoginFunction=()=>
{
     if (email.length == 0) {
      toast.warning('please enter email')
    } 
    else  if(!email.includes("@"))
    {
      toast.warning('please enter correct email')
    }
    else if (password.length == 0) {
      toast.warning('please enter password')
    } else {

     
        const body = {
          email,
          password,
        }
         axios.post(`${URL}/users/login`,body).then((response)=>
         {
          const result = response.data
          if (result['status'] == 'success') {
            toast.success('Welcome to the application')
            const { userId, name, email,phone,profileImage,role } = result['data']
            //console.log(profileImage)
            sessionStorage['userId'] = userId
            sessionStorage['name'] = name
            sessionStorage['email'] = email
            sessionStorage['phone'] = phone
            sessionStorage['profileImage'] = profileImage
            sessionStorage['role'] = role
            sessionStorage['loginStatus'] = 1
            navigate('/home')
          }
          else
          {
           
            toast.error(result['error'])
          }
         })
        
      }
     
}


  return (
   
<div className='container' id='maincontainer'>

<div class="row">
    <div class="col" id='divlogin'>
    <div class="col" id='divheading'>
    <span className='text-secondary'>Restaurant Management System</span>
    </div>
    <hr/>
    <div >
  <h2>Log In</h2>
 <form > 

 <div class="form-outline mb-4">
 <label  class="form-label" for="typeEmailX-2">Email</label>
              <input onChange={(e)=>{setEmail(e.target.value)}} type="email"  class="form-control form-control-lg" placeholder='abc@gmail.com'  />
             
            </div>

            <div class="form-outline mb-4">
            <label class="form-label" for="typePasswordX-2">Password</label>
              <input onChange={(e)=>{setPassword(e.target.value)}} type="password"  class="form-control form-control-lg" placeholder='**********'  />
              
            </div>

           
 </form>
 <button  onClick={LoginFunction} class="btn btn-primary btn-lg btn-block" >Login</button>
</div>
    </div>
    <div class="col" id='divimage'>
     
    </div>
  </div>
</div>

   
  )
}

export default Login