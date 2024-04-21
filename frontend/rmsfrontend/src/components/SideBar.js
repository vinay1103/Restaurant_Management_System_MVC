
import {FaHome,FaBars,FaUser} from "react-icons/fa"
import {BiCategory} from "react-icons/bi"
import {MdFoodBank,MdBorderColor,MdLogout} from "react-icons/md"
import {AiFillDashboard,AiFillSetting} from "react-icons/ai"
import {SiAirtable} from "react-icons/si"
import {RiBillFill} from "react-icons/ri"
import {GiCookingPot} from "react-icons/gi"
import { NavLink } from "react-router-dom";


const route=
    {
        path:"/home",
        name:"DashBoard",
        icon:<AiFillDashboard/>
    };

    const route2=
    {
        path:"/category",
        name:"Category",
        icon:<BiCategory/>
    };

    const route3=
    {
        path:"/product",
        name:"Product",
        icon:<MdFoodBank/>
    };
    const route4=
    {
        path:"/order",
        name:"Order",
        icon:<MdBorderColor/>
    };
    const route5=
    {
        path:"/tables",
        name:"Tables",
        icon:<SiAirtable/>
    };
    const route6=
    {
        path:"/users",
        name:"Users",
        icon:<FaUser/>
    };
    const route7=
    {
        path:"/bill",
        name:"Bill",
        icon:<RiBillFill/>
    };
    const route8=
    {
        path:"/setting",
        name:"Settings",
        icon:<AiFillSetting/>
    };
    const route9=
    {
        path:"/logout",
        name:"Logout",
        icon:<MdLogout/>
    };

    const route10=
    {
        path:"/orderchef",
        name:"Orders",
        icon:<GiCookingPot/>
    };

    
const SideBar=({children})=>
{


    const role=sessionStorage['role']
    return (
    <div className="maincontainer">
        <div   className="side_bar">
   <div className="top_section">
      <h1 className="logo" >Hungry Foods</h1>
       
   </div>
   
    <section className="routes">
      
      
      <NavLink activeClassName="active" to={route.path} key={route.name} className="link" >
               <div className="icon">
              {route.icon}
               </div>
           <div  className="link_text">
              {route.name}
               </div>
           
           </NavLink>

           {(role=="chef") &&  <NavLink activeClassName="active" to={route10.path} key={route10.name} className="link" >
               <div className="icon">
              {route10.icon}
               </div>
               <div  className="link_text">
              {route10.name}
               </div>
           </NavLink>}


           {(role=="manager" ||role=="chef") &&  <NavLink activeClassName="active" to={route2.path} key={route2.name} className="link" >
               <div className="icon">
              {route2.icon}
               </div>
               <div  className="link_text">
              {route2.name}
               </div>
           </NavLink>}

           {(role=="manager" ||role=="chef") &&  <NavLink activeClassName="active" to={route3.path} key={route3.name} className="link" >
               <div className="icon">
              {route3.icon}
               </div>
               <div  className="link_text">
              {route3.name}
               </div>
           </NavLink>}

         

        
           {(role=="manager" ||role=="waiter") && <NavLink activeClassName="active" to={route4.path} key={route4.name} className="link" >
               <div className="icon">
              {route4.icon}
               </div>
               <div  className="link_text">
              {route4.name}
               </div>
           </NavLink>}

           {(role=="manager") && <NavLink activeClassName="active" to={route5.path} key={route5.name} className="link" >
               <div className="icon">
              {route5.icon}
               </div>
               <div  className="link_text">
              {route5.name}
               </div>
           </NavLink>}

        {(role=="manager") && <NavLink activeClassName="active" to={route6.path} key={route6.name} className="link" >
               <div className="icon">
              {route6.icon}
               </div>
               <div  className="link_text">
              {route6.name}
               </div>
           </NavLink>}

           {(role=="manager" ||role=="cashier") &&   <NavLink activeClassName="active" to={route7.path} key={route7.name} className="link" >
               <div className="icon">
              {route7.icon}
               </div>
               <div  className="link_text">
              {route7.name}
               </div>
           </NavLink>}
           <NavLink activeClassName="active" to={route8.path} key={route8.name} className="link" >
               <div className="icon">
              {route8.icon}
               </div>
               <div  className="link_text">
              {route8.name}
               </div>
           </NavLink>
           <NavLink activeClassName="active" to={route9.path} key={route9.name} className="link" >
               <div className="icon">
              {route9.icon}
               </div>
               <div  className="link_text">
              {route9.name}
               </div>
           </NavLink>
   
    </section>
    </div>
    <main>
        {children}
    </main>
    
    </div>);
};

export default SideBar;