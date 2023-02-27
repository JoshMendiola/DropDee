import React from 'react';
import MainAppBar from "../components/MainAppBar";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import HomePage from "../pages/HomePage";
import UserRegistrationPage from "../pages/UserRegistrationPage";



export default function App()
{
    return (
        <Router>
            <div className="App">
                <MainAppBar/>
                <div className="content">
                    <Routes>
                        <Route path = "/" element={<HomePage/>}> </Route>
                        <Route path = "/register" element={<UserRegistrationPage/>}> </Route>
                    </Routes>
                </div>
            </div>
        </Router>

    );
}