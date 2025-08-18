import Message from '../components/Message'

function MessageHolder (isLoggedIn, message) {
    return (
        <div>
            {
                isLoggedIn ? <Message message={message}/> : null
            }
        </div>
    )
}

export default MessageHolder