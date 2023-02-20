import React from 'react';
import MainAppBar from "./components/MainAppBar";
import PopularBandsList from "./components/PopularBandsList"
import BandRegistration from "./components/BandRegistration";


function Home() {

    return (
      <div className="App">
          <MainAppBar/>
          <PopularBandsList/>
          <BandRegistration/>
      </div>
  )
}


export default Home;
