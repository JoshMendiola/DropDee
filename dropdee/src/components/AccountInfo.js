import React, {useEffect, useState} from 'react';

function AccountInfo(props)
{
    const [userinfo, setUserinfo] = useState(props.userInfo)

    useEffect(() => {
        setUserinfo(props.userInfo);
        console.log(props.userInfo)
    }, [props.userInfo]);

    return (
        <div>
            <h1>{userinfo}</h1>
        </div>
    );
}

export default AccountInfo;