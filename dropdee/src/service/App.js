import React, {useState} from 'react';
import LoggedOutAppBar from "../components/LoggedOutAppBar";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import HomePage from "../pages/HomePage";
import UserRegistrationPage from "../pages/UserRegistrationPage";
import UserLoginPage from "../pages/UserLoginPage";
import LoggedInAppBar from "../components/LoggedInAppBar";
import AuthContext from "./AuthContext";



export default function App()
{

    const [loggedIn, setLoggedIn] = useState(false);
    function changeAppBar() {
        setLoggedIn(true);
    }

    return (
        <Router>
            <div className="App">
                <AuthContext.Provider value={{ loggedIn, changeAppBar }}>
                    {loggedIn ? <LoggedInAppBar /> : <LoggedOutAppBar />}
                </AuthContext.Provider>
                <div className="content">
                    <Routes>
                        <Route path = "/" element={<HomePage/>}> </Route>
                        <Route path = "/register" element={<UserRegistrationPage/>}> </Route>
                        <Route path = "/login" element={<UserLoginPage changeAppBar={changeAppBar}/>}> </Route>
                    </Routes>
                </div>
            </div>
        </Router>

    );
}