import React, {useEffect, useState} from 'react';
import LoggedOutAppBar from "../components/LoggedOutAppBar";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import HomePage from "../pages/HomePage";
import UserRegistrationPage from "../pages/UserRegistrationPage";
import UserLoginPage from "../pages/UserLoginPage";
import LoggedInAppBar from "../components/LoggedInAppBar";
import AuthContext from "./AuthContext";
import AccountPage from "../pages/AccountPage";



export default function App()
{

    const [loggedIn, setLoggedIn] = useState(false);
    const [userID, setUserID] = useState(null)

    useEffect(() => {
    }, [userID]);

    function handleLogin(ID) {
        setLoggedIn(true);
        setUserID(ID)
    }

    return (
        <Router>
            <div className="App">
                <AuthContext.Provider value={{ loggedIn, handleLogin }}>
                    {loggedIn ? <LoggedInAppBar /> : <LoggedOutAppBar/>}
                </AuthContext.Provider>
                <div className="content">
                    <Routes>
                        <Route path = "/" element={<HomePage/>}> </Route>
                        <Route path = "/register" element={<UserRegistrationPage handleLogin={handleLogin}/>}> </Route>
                        <Route path = "/login" element={<UserLoginPage handleLogin={handleLogin}/>}> </Route>
                        <Route path = "/account" element={<AccountPage userID = {userID}/>}> </Route>
                    </Routes>
                </div>
            </div>
        </Router>

    );
}