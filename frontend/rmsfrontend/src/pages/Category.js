import axios from "axios";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import NavBar from "../components/NavBar";
import SideBar from "../components/SideBar";
import { URL } from "../config";
import '../css/Category.css'

const Category=()=>
{

    const [id, setId] = useState(0);
    const [name, setName] = useState("");
    const [category,setCategory]=useState([])

const getData=()=>
{
    axios.get(`${URL}/categories`).then((response)=>
    {

        const result = response.data;
        setCategory(result.data)

    })

}

const addData=()=>
{

    if(name.length==0)
    {
            toast.warning("Pleade Enter Name")
    }
    else
    {
    const body ={
        "categoryName":name
    }

    axios.post(`${URL}/categories`,body).then((response)=>
    {
        const result = response.data;
        if (result['status'] == 'success') {
            toast.success('Category Added Successfully')
            getData()

        }
        else
        {
            toast.error("Unable to Add Category")
        }


    
    })

}
}

const deleteData=( id)=>
{
    axios.delete(`${URL}/categories/${id}`).then((response)=>
    {
 
            const result = response.data;
        getData()
    })
}

const editData=( name,id)=>
{
    setId(id)
    setName(name)
}

const updateData=()=>
{

    const body ={
    "categoryName":name
    }
  
    axios.put(`${URL}/categories/${id}`,body).then((response)=>
    {
 
        const result = response.data;
        if (result['status'] == 'success') {
            toast.success('Data Updated Successfully')
            getData()
    
        }
        else
        {
            toast.error("Unable to Update Data")
        }
 })
}

const updateStatus=(status,id)=>
{

    if(status=="Enabled")
    {
        const body ={
            "categoryStatus":"Disabled"
        }
        axios.patch(`${URL}/categories/${id}`,body).then((response)=>
        {
 
        const result = response.data;
        getData()
        })
    }
    else
    {
        const body ={
            "categoryStatus":"Enabled"
        }
      
        axios.patch(`${URL}/categories/${id}`,body).then((response)=>
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
        <h5 className="modal-title fs-3 fw-bold" id="exampleModalLabel">Add Category</h5>
        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div className="modal-body">
       <form >
       <label style={{marginRight:"5px"}} className="fs-5">Name: </label>
       <input   onChange={(e)=>{setName(e.target.value)}} className="form-control" type="text" />


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
        <h5 className="modal-title fs-3 fw-bold" id="exampleModalLabel">Edit Category</h5>
        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div className="modal-body">
       <form  method="post">
       <label  className="fs-5" >Name: </label>
       <input  value={name}  onChange={((e)=>{setName(e.target.value)})} type="text" className="form-control" />


       </form>
      </div>
      <div className="modal-footer">
        <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button onClick={updateData} type="button" className="btn btn-primary" data-bs-dismiss="modal" >Save changes</button>
      </div>
    </div>
  </div>
</div>












        <div className="mainelementcat">
        <h2 style={{textAlign:"center"}}>Category Details</h2>
<hr />

<button data-bs-toggle="modal" data-bs-target="#addModal" style={{marginLeft:"40px",marginBottom:"10px"}} className="btn btn-success btn-lg">Add</button>
        <div className="subelementcat">




<table id="cattableid" style={{textAlign:"center"}}  class="table table-bordered table-hover  mb-0">
    <thead>
      <tr className="tablerowcat">
        <th scope="col">Category Name</th>
     
        <th scope="col">Status</th>
        <th scope="col">Action</th>
      </tr>
    </thead> 

    <tbody>

    {
     
     category.map((cat)=>
      {
        
          return(
            <tr key={cat.categoryId}>
            <th scope="col">{cat.categoryName} </th>
           
            <td>
                {cat.categoryStatus=="Enabled" ? <button onClick={updateStatus.bind(this,cat.categoryStatus,cat.categoryId)} className="btn btn-success btn-md">{cat.categoryStatus}</button>: <button onClick={updateStatus.bind(this,cat.categoryStatus,cat.categoryId)}  className="btn btn-danger btn-md">{cat.categoryStatus}</button>}
               
                
                </td>
            <td><button style={{marginRight:"20px"}} className="btn btn-info btn-md"  data-bs-toggle="modal" data-bs-target="#editModal" onClick={editData.bind(this,cat.categoryName,cat.categoryId)}>Edit</button>
            <button onClick={deleteData.bind(this,cat.categoryId)} className="btn btn-warning btn-md">Delete</button></td>
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

export default Category;