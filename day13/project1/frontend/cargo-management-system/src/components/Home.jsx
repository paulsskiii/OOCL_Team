import { Link } from 'react-router'

const Home = () => {
  return (
    <div>
      <h1>Welcome Customer!</h1>
      <Link to='/containers'>View Containers</Link>
    </div>
  )
}

export default Home