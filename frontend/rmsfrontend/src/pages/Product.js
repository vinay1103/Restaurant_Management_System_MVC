import axios from "axios";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import NavBar from "../components/NavBar";
import SideBar from "../components/SideBar";
import { URL } from "../config";
import '../css/Product.css'

const Product=()=>
{

    const [id, setId] = useState(0);
    const [categoryId, setCategoryId] = useState(0);
    const [price, setPrice] = useState(0.0);
    const [name, setName] = useState("");
    const [product,setProduct]=useState([])
    const [category,setCategory]=useState([])

const getData=()=>
{
    axios.get(`${URL}/products`).then((response)=>
    {

        const result = response.data;
        setProduct(result.data)

    })

}

const getCategoryData=()=>
{
    axios.get(`${URL}/categories/active`).then((response)=>
    {

        const result = response.data;
        setCategory(result.data)

    })

}

const addData=()=>
{

  if(name.length==0||price.length==0||categoryId.length==0)
  {
    toast.warning("Please Enter All Data")
  }
  else
  {
    const body ={
        "productName": name,
        "productPrice": price,
        "productcategoryId": categoryId
    }

    axios.post(`${URL}/products`,body).then((response)=>
    {
        const result = response.data;
        if (result['status'] == 'success') {
            toast.success('Product Added Successfully')
            getData()

        }
        else
        {
            toast.error("Unable to Add Product")
        }
    })
  }
 
}

const deleteData=( id)=>
{
    axios.delete(`${URL}/products/${id}`).then((response)=>
    {
 
            const result = response.data;
        getData()
    })
}

const editData=( name,id,price)=>
{

    setId(id)
    setName(name)
    setPrice(price)
}

const updateData=()=>
{

    const body ={
        "productName": name,
        "productPrice": price
       
}
  
    axios.put(`${URL}/products/${id}`,body).then((response)=>
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
            "productStatus": "Disabled"
        }
        axios.patch(`${URL}/products/${id}`,body).then((response)=>
        {
 
        const result = response.data;
        getData()
        })
    }
    else
    {
        const body ={
            "productStatus": "Enabled"
        }
      
        axios.patch(`${URL}/products/${id}`,body).then((response)=>
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
        <h5 className="modal-title fs-3 fw-bold" id="exampleModalLabel">Add Product</h5>
        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div className="modal-body">
       <form >
       <label style={{marginRight:"5px",marginTop:"5px"}} className="fs-5">Category: </label>
       <select defaultValue="1" className="form-select" onChange={(e)=>{setCategoryId(e.target.value)}} >
       <option disabled selected value> -- Choose Category -- </option>
           {
               category.map((cat)=>
               {
               return  <option value={cat.categoryId}>{cat.categoryName}</option>
               })
           }
           
           
          </select>
          <label style={{marginRight:"5px",marginTop:"5px"}} className="fs-5">Name: </label>
       <input   onChange={(e)=>{setName(e.target.value)}} className="form-control" type="text" />
       <label style={{marginRight:"5px",marginTop:"5px"}} className="fs-5">Price: </label>
       <input   onChange={(e)=>{setPrice(e.target.value)}} className="form-control" type="text" />
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
        <h5 className="modal-title fs-3 fw-bold" id="exampleModalLabel">Edit Product</h5>
        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div className="modal-body">
       <form  method="post">
          <label style={{marginRight:"5px",marginTop:"5px"}} className="fs-5">Name: </label>
       <input  value={name} onChange={(e)=>{setName(e.target.value)}} className="form-control" type="text" />
       <label style={{marginRight:"5px",marginTop:"5px"}} className="fs-5">Price: </label>
       <input value={price}  onChange={(e)=>{setPrice(e.target.value)}} className="form-control" type="text" />


       </form>
      </div>
      <div className="modal-footer">
        <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button onClick={updateData} type="button" className="btn btn-primary" data-bs-dismiss="modal" >Save changes</button>
      </div>
    </div>
  </div>
</div>



        <div className="mainelementpro">
        <h2 style={{textAlign:"center"}}>Product Details</h2>
<hr />

<button onClick={getCategoryData} on data-bs-toggle="modal" data-bs-target="#addModal" style={{marginLeft:"40px",marginBottom:"10px"}} className="btn btn-success btn-lg">Add</button>
        <div className="subelementpro">

<table id="protableid" style={{textAlign:"center"}}  class="table table-bordered table-hover  mb-0">
    <thead>
      <tr className="tablerowpro">
        <th scope="col">Product Name</th>
        <th scope="col">Category</th>
        <th scope="col">Price</th>
        <th scope="col">Status</th>
        <th scope="col">Action</th>
      </tr>
    </thead> 

    <tbody>

    {
     
     product.map((pro)=>
      {
        
          return(
            <tr key={pro.productId}>
            <th scope="col">{pro.productName} </th>
            <td scope="col">{pro.productcategoryName} </td>
            <td scope="col">Rs. {pro.productPrice} </td>
            <td>
                {pro.productStatus=="Enabled" ? <button onClick={updateStatus.bind(this,pro.productStatus,pro.productId)} className="btn btn-success btn-md">{pro.productStatus}</button>: <button onClick={updateStatus.bind(this,pro.productStatus,pro.productId)}  className="btn btn-danger btn-md">{pro.productStatus}</button>}
               
                
                </td>
            <td><button style={{marginRight:"20px"}} className="btn btn-info btn-md"  data-bs-toggle="modal" data-bs-target="#editModal" onClick={editData.bind(this,pro.productName,pro.productId,pro.productPrice)}>Edit</button>
            <button onClick={deleteData.bind(this,pro.productId)} className="btn btn-warning btn-md">Delete</button></td>
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


export default Product;