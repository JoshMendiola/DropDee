import React from 'react';
import UnloggedAppBar from "../components/UnloggedAppBar";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import HomePage from "../pages/HomePage";
import UserRegistrationPage from "../pages/UserRegistrationPage";
import UserLoginPage from "../pages/UserLoginPage";
import AppBarController from "./AppBarController";



export default function App()
{
    return (
        <Router>
            <div className="App">
                <AppBarController/>
                <div className="content">
                    <Routes>
                        <Route path = "/" element={<HomePage/>}> </Route>
                        <Route path = "/register" element={<UserRegistrationPage/>}> </Route>
                        <Route path = "/login" element={<UserLoginPage/>}> </Route>
                    </Routes>
                </div>
            </div>
        </Router>

    );
}