  
    useEffect(() => {
    // storing input name
    localStorage.setItem(
        "firstName", 
        "lastName", 
        
        JSON.stringify(
            firstName, 
            lastName ));

    }, [firstName,
         lastName]);