import './App.css'
import Header from './components/Header'
import Bio from './components/Bio'
import Skills from './components/Skills'
import Footer from './components/Footer'
import About from './components/About'

function App() {

  return (
    <div>
      <Header />
      <Bio
        name='Russel'
        profile={'https://media2.giphy.com/media/v1.Y2lkPTc5MGI3NjExaGRkOXdjbWF3enpidWtqOWpsa3VldHpsaDl4ejFvYTkzaXc4Z3B2bSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/v5LGVtcBFTV5K/giphy.gif'}
        bio="Lorem ipsum dolor sit amet consectetur adipisicing elit. Illum quas quis cumque nisi nostrum, molestiae aspernatur optio, voluptates accusantium maxime, beatae quasi sequi distinctio dolore fugiat sit culpa unde quos!"
      />
      <About />
      <Skills skill='Skill'
        description='Lorem ipsum dolor sit amet, consectetur adipisicing elit.'
      />
      <Footer />
    </div>
  )
}

export default App
