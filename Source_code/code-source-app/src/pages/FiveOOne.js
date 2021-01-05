import React from 'react';
import GradientLink from '../components/common/GradientLink';

const FiveOOne = () => {
  return (
    <div className="flex flex-col items-center h-screen">
      <h1 className="text-6xl font-bold text-gray-800 mt-10">
        501
      </h1>
      <h2 className="text-4xl">Function is not implemented yet</h2>
      <div className="mt-2">
        <GradientLink text="Go Back Home" to="/" />
      </div>
    </div>
  );
};

export default FiveOOne;
