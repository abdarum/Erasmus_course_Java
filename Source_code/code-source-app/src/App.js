import React, { lazy, Suspense, useContext } from 'react';
import {
  BrowserRouter as Router,
  Route,
  Switch,
  Redirect
} from 'react-router-dom';
import './App.css';

import {
  AuthProvider,
  AuthContext
} from './context/AuthContext';
import { FetchProvider } from './context/FetchContext';

import AppShell from './AppShell';

import Home from './pages/Home';
import Login from './pages/Login';
import Signup from './pages/Signup';
import FourOFour from './pages/FourOFour';
import FiveOOne from './pages/FiveOOne';

const Order = lazy(() => import('./pages/Order'));
const FindBooks = lazy(() => import('./pages/FindBooks'));
const Account = lazy(() => import('./pages/Account'));
const Settings = lazy(() => import('./pages/Settings'));
const Readers = lazy(() => import('./pages/Readers'));
const Users = lazy(() => import('./pages/Users'));
const ManageBooks = lazy(() => import('./pages/ManageBooks'));
const ManageOrders = lazy(() => import('./pages/ManageOrders'));
const Reports = lazy(() => import('./pages/Reports'));
const ReportSubmitted = lazy(() => import('./pages/ReportSubmitted'));
const ReportBooks = lazy(() => import('./pages/ReportBooks'));
const ReportUsers = lazy(() => import('./pages/ReportUsers'));

const LoadingFallback = () => (
  <AppShell>
    <div className="p-4">Loading...</div>
  </AppShell>
);

const UnauthenticatedRoutes = () => (
  <Switch>
    <Route path="/login">
      <Login />
    </Route>
    <Route path="/signup">
      <Signup />
    </Route>
    <Route exact path="/">
      <Home />
    </Route>
    <Route path="*">
      <FourOFour />
    </Route>
  </Switch>
);

const AuthenticatedRoute = ({ children, ...rest }) => {
  const auth = useContext(AuthContext);
  return (
    <Route
      {...rest}
      render={() =>
        auth.isAuthenticated() ? (
          <AppShell>{children}</AppShell>
        ) : (
            <Redirect to="/" />
          )
      }
    ></Route>
  );
};

const AdminRoute = ({ children, ...rest }) => {
  const auth = useContext(AuthContext);
  return (
    <Route
      {...rest}
      render={() =>
        auth.isAuthenticated() && auth.isAdmin() ? (
          <AppShell>{children}</AppShell>
        ) : (
            <Redirect to="/" />
          )
      }
    ></Route>
  );
};

const LibrarianRoute = ({ children, ...rest }) => {
  const auth = useContext(AuthContext);
  return (
    <Route
      {...rest}
      render={() =>
        auth.isAuthenticated() && auth.isLibrarian() ? (
          <AppShell>{children}</AppShell>
        ) : (
            <Redirect to="/" />
          )
      }
    ></Route>
  );
};

const AppRoutes = () => {
  return (
    <>
      <Suspense fallback={<LoadingFallback />}>
        <Switch>
          <AuthenticatedRoute path="/notimplemented">
            <FiveOOne />
          </AuthenticatedRoute>
          <AuthenticatedRoute path="/find-books">
            <FindBooks />
          </AuthenticatedRoute>
          <AuthenticatedRoute path="/order">
            <Order />
          </AuthenticatedRoute>
          <AuthenticatedRoute path="/account">
            <Account />
          </AuthenticatedRoute>
          <AuthenticatedRoute path="/settings">
            <Settings />
          </AuthenticatedRoute>
          <AdminRoute path="/users">
            <Users />
          </AdminRoute>
          <AdminRoute path="/readers">
            <Readers />
          </AdminRoute>
          <LibrarianRoute path="/readers">
            <Readers />
          </LibrarianRoute>
          <LibrarianRoute path="/manage-books">
            <ManageBooks />
          </LibrarianRoute>
          <AuthenticatedRoute path="/manage-orders">
            <ManageOrders />
          </AuthenticatedRoute>
          <AdminRoute path="/reports">
            <Reports />
          </AdminRoute>
          <AdminRoute path="/inventory/submitted">
            <ReportSubmitted />
          </AdminRoute>
          <AdminRoute path="/inventory/books">
            <ReportBooks />
          </AdminRoute>
          <AdminRoute path="/inventory/users">
            <ReportUsers />
          </AdminRoute>
          <AdminRoute path="/inventory/userrating">
            {/* <ReportUserrating  /> */}
          </AdminRoute>
          <UnauthenticatedRoutes />
        </Switch>
      </Suspense>
    </>
  );
};

function App() {
  return (
    <Router>
      <AuthProvider>
        <FetchProvider>
          <div className="bg-gray-100">
            <AppRoutes />
          </div>
        </FetchProvider>
      </AuthProvider>
    </Router>
  );
}

export default App;
