
import './App.css';
import api from './api/axiosCongig';
import { useState ,useEffect} from 'react';
import Layout from './component/Layout';
import {Routes,Route} from 'react-router-dom';
import Home from'./component/home/Home';
import Header from './component/header/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import Trailer from './component/trailer/Trailer';
import Reviews from './component/reviews/Reviews';


function App() {
  const [movies, setMovies] = useState([]);  // Initialize as an array
  const [movie, setMovie] = useState({});    // Initialize as an object
  const [reviews, setReviews] = useState([]); // Initialize as an arra
  const getMovies =async ()=>{
    try{
    const response=await api.get("/api/v1/movies");
    setMovies(response.data);
    }
    catch(err)
    {
     console.log(err);
    }
  }
  const getMovieData=async (movieId) =>{
     try{
         const response =await api.get(`/api/v1/movies/${movieId}`);
         const singleMovie=response.data;
         setMovie(singleMovie);
         setReviews(singleMovie.setReviews);
     }
     catch(err){

     }
  }
  
  useEffect(()=>{
      getMovies();
  },[])
  return (
    <div className="App">
      <Header/>
      


     <Routes>
       <Route path="/" element={<Layout/>}>
       <Route path='/' element={<Home movies={movies}/>} ></Route>
       <Route path="/Trailer/:ytTrailerId" element={<Trailer/>}> </Route>
       <Route path="/Reviews/:movieId" element={<Reviews getMovieData={getMovieData} movie={movie} reviews ={reviews} setReviews={setReviews}/>}></Route>

       </Route>
     </Routes>

    </div>
  );
}

export default App;
