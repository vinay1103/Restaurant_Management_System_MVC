
import { BrowserRouter, Route, Routes, Link } from 'react-router-dom'
import './css/SideBar.css';
import SideBar from './components/SideBar';
import Bill from './pages/Bill';
import Category from './pages/Category';
import Home from './pages/Home';
import Orders from './pages/Orders';
import Product from './pages/Product';
import Tables from './pages/Tables';
import User from './pages/User';
import Login from './pages/Login';
import Logout from './pages/Logout';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css'
import Setting from './pages/Setting';
import OrdersChef from './pages/OrdersChef';


const AuthorizeUser = () => {
  const loginStatus = sessionStorage['loginStatus']
  return loginStatus == '1' ? <Home /> : <Login />
}
const AuthorizeHome = () => {
  const loginStatus = sessionStorage['loginStatus']
  return loginStatus == '1' ? <Home /> : <Login />
}
const AuthorizeCategory = () => {
  const loginStatus = sessionStorage['loginStatus']
  return loginStatus == '1' ? ((sessionStorage['role']=='manager'||sessionStorage['role']=='chef')?<Category />:<Home/> ): <Login />
}
const AuthorizeProduct = () => {
  const loginStatus = sessionStorage['loginStatus']
  return loginStatus == '1' ? ((sessionStorage['role']=='manager'||sessionStorage['role']=='chef')?<Product />:<Home/> ) : <Login />
}
const AuthorizeOrders = () => {
  const loginStatus = sessionStorage['loginStatus']
  return loginStatus == '1' ? ((sessionStorage['role']=='manager'||sessionStorage['role']=='waiter')?<Orders />:<Home/> ): <Login />
}
const AuthorizeOrdersChef = () => {
  const loginStatus = sessionStorage['loginStatus']
  return loginStatus == '1' ? ((sessionStorage['role']=='chef')?<OrdersChef />:<Home/> ): <Login />
}
const AuthorizeTables = () => {
  const loginStatus = sessionStorage['loginStatus']
  return loginStatus == '1' ? ((sessionStorage['role']=='manager')?<Tables />:<Home/> ) : <Login />
}
const AuthorizeUsers = () => {
  const loginStatus = sessionStorage['loginStatus']
  return loginStatus == '1' ? ((sessionStorage['role']=='manager')?<User />:<Home/> ) : <Login />
}
const AuthorizeBill = () => {
  const loginStatus = sessionStorage['loginStatus']
  return loginStatus == '1' ? ((sessionStorage['role']=='manager'||sessionStorage['role']=='cashier')?<Bill />:<Home/> ) : <Login />
}
const AuthorizeSetting = () => {
  const loginStatus = sessionStorage['loginStatus']
  return loginStatus == '1' ? <Setting /> : <Login />
}
const AuthorizeLogin = () => {
  const loginStatus = sessionStorage['loginStatus']
  return loginStatus == '1' ? <Home /> : <Login />
}
const AuthorizeLogout = () => {
  const loginStatus = sessionStorage['loginStatus']
  return loginStatus == '1' ? <Logout /> : <Login />
}


function App() {
  return (
    <div >
    <BrowserRouter>
      <Routes>
      <Route path="/" element={<AuthorizeUser />} />
        <Route path="/home" element={<AuthorizeHome />}/>
        <Route path="/category" element={<AuthorizeCategory />} />
        <Route path="/product" element={<AuthorizeProduct />} />
        <Route path="/order" element={<AuthorizeOrders />} />
        <Route path="/orderchef" element={<AuthorizeOrdersChef />} />
        <Route path="/tables" element={<AuthorizeTables />} />
        <Route path="/users" element={<AuthorizeUsers />} />
        <Route path="/bill" element={<AuthorizeBill />} />
        <Route path="/login" element={<AuthorizeLogin />} />
        <Route path="/logout" element={<AuthorizeLogout />} />
        <Route path="/setting" element={<AuthorizeSetting/>} />
      </Routes>
    </BrowserRouter>
    <ToastContainer theme="colored" />
  </div>


  );
}

export default App;
