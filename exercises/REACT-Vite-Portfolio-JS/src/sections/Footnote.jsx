function Footnote ({isLoggedIn, setLoggedIn}) {

    return (
        <footer id="footnote" className="content-container">
          {
            isLoggedIn ? <button onClick={setLoggedIn (false)}>Log in</button> : <button onClick={setLoggedIn (false)}>Log false</button>
          }
      </footer>
    )
}

export default Footnote;