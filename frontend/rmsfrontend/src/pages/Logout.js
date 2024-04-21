import React, { useEffect } from 'react'
import { useNavigate } from 'react-router'
import { toast } from 'react-toastify'
import '../css/Logout.css'
const Logout = () => {

    const navigate = useNavigate()
    const LogoutFunction=()=>
{
    
   
    
}

useEffect(() => {
    sessionStorage['userId'] = 0
    sessionStorage['name'] = null
    sessionStorage['email'] = null
    sessionStorage['phone'] = null
    sessionStorage['profileImage'] = null
    sessionStorage['role'] = null
    sessionStorage['loginStatus'] = 0
    toast.success("Logged Out Successfully")
    navigate('/login')
   
  }, [])
  return (
    <div>
        <div className='container' id='maincontainer'> 
        
        <div className="subelements">
        

            <div className="subelementimg">
           <img src='https://cdn.iconscout.com/icon/free/png-256/unlock-unsecure-protect-theft-7-16391.png'></img>
            </div>
           

            <div className="subelementtext">
                <p className='logouttext'>Logged Out</p>
            <button class="btn btn-primary btn-lg btn-block" onClick={LogoutFunction}>Click me</button>
         
            </div>
        </div>
        </div>
      

    </div>
  )
}

export default Logout