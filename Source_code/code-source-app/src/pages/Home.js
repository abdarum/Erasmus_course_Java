import React, { useContext } from 'react';
import { Link } from 'react-router-dom';
import { AuthContext } from './../context/AuthContext';
import GradientLink from '../components/common/GradientLink';
import GradientBar from './../components/common/GradientBar';
import logo from './../images/logo.png';
import background from './../images/background.jpg';


const Home = () => {
  const auth = useContext(AuthContext);

  return (
    <>
      <GradientBar />
      <div className="w-full top-0 bg-white px-10 py-5">
        <div className="flex justify-between">
          <img
            className="w-32 h-full"
            src={logo}
            alt="Logo"
          />
          <div className="flex items-center">
            <Link
              to="/signup"
              className="text-blue-700 mr-6"
            >
              Sign Up
            </Link>
            <GradientLink
              to={
                auth.isAuthenticated()
                  ? '/find-books'
                  : '/login'
              }
              text="Log In"
            />
          </div>
        </div>
      </div>
      <div className="h-full bg-yellow-700">
        <div className="opacity-10">
          <img
            className="object-fill w-full"
            src={background}
            alt="Home"
          />
        </div>
        <div className="absolute left-0 top-0 mt-32 lg:mt-48 px-12 nato-sans">
          <div className="w-full lg:w-2/3">
            <h1 className="text-gray-200 text-2xl lg:text-6xl sm:text-5xl font-bold leading-tight">
              Sales Data Management That Works For Your Team
            </h1>
            <h2 className="text-gray-400 text-md sm:text-2xl sm:mt-10 mt-4">
              Take the pain out of managing your sales data
            </h2>
            <div className="mt-4 sm:mt-10 w-48">
              <GradientLink
                text="Get Started"
                size="lg"
                to={
                  auth.isAuthenticated()
                    ? '/find-books'
                    : '/login'
                }
              />
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Home;
