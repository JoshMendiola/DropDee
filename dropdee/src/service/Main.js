import React from 'react';
import {Routes, Route } from 'react-router-dom';

import Home from '../pages/Home';
import UserRegistrationPage from '../pages/UserRegistrationPage';

const Main = () => {
    return (
        <Routes> {/* The Switch decides which component to show based on the current URL.*/}
            <Route exact path='/' component={Home}></Route>
            <Route exact path='/registration' component={UserRegistrationPage}></Route>
        </Routes>
    );
}

export default Main;