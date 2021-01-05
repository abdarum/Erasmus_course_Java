import React, { useContext } from 'react';
import classNames from 'classnames';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  faChartLine,
  faUserGraduate,
  faChalkboardTeacher,
  faTasks,
  faList,
  faAddressCard,
  faChartPie,
  faCogs,
  faUsersCog
} from '@fortawesome/free-solid-svg-icons';
import { Link, useLocation } from 'react-router-dom';
import logo from './../images/logo.png';
import { AuthContext } from './../context/AuthContext';
import { useTranslation } from "react-i18next";

const navItems = [
  {
    label: 'components.sidebar_component.link_label.dashboard',
    path: 'dashboard',
    icon: faChartLine,
    allowedRoles: ['old_user']
  },
  {
    label: 'components.sidebar_component.link_label.inventory',
    path: 'inventory',
    icon: faChartPie,
    allowedRoles: ['old_user']
  },
  {
    label: 'components.sidebar_component.link_label.find_lessons',
    path: 'find-lessons',
    icon: faUserGraduate,
    allowedRoles: ['student', 'teacher']
  },
  {
    label: 'components.sidebar_component.link_label.become_a_teacher',
    path: 'teacher-dashboard',
    icon: faChalkboardTeacher,
    allowedRoles: ['student']
  },
  {
    label: 'components.sidebar_component.link_label.teacher_lessons',
    path: 'teacher-dashboard',
    icon: faTasks,
    allowedRoles: ['teacher']
  },
  {
    label: 'components.sidebar_component.link_label.lesson_items',
    path: 'notimplemented',
    icon: faList,
    allowedRoles: ['admin'] // remove admin
  },
  {
    label: 'components.sidebar_component.link_label.users',
    path: 'users',
    icon: faUsersCog,
    allowedRoles: ['admin']
  },
  {
    label: 'components.sidebar_component.link_label.account',
    path: 'account',
    icon: faAddressCard,
    allowedRoles: ['student',  'teacher', 'admin']
  },
  {
    label: 'components.sidebar_component.link_label.settings',
    path: 'settings',
    icon: faCogs,
    allowedRoles: ['student',  'teacher', 'admin']
  }
];

const NavItem = ({ navItem }) => {
  const { t  } = useTranslation('common');
  const location = useLocation();
  const isCurrentRoute =
    location.pathname === `/${navItem.path}`;
  const classes = classNames({
    'px-2 sm:px-6 justify-center sm:justify-start py-3 rounded-full flex': true,
    'text-gray-600 hover:text-blue-500 transform hover:translate-x-1 transition ease-in-out duration-100': !isCurrentRoute,
    'bg-gradient text-gray-100 shadow-lg': isCurrentRoute
  });
  return (
    <Link to={navItem.path} className={classes}>
      <div className="flex items-center">
        <div className="mr-0 sm:mr-4">
          <FontAwesomeIcon icon={navItem.icon} />
        </div>
        <span className="hidden sm:block">
          {t(navItem.label)}
        </span>
      </div>
    </Link>
  );
};

const NavItemContainer = ({ children }) => (
  <div>{children}</div>
);

const Sidebar = () => {
  const auth = useContext(AuthContext);
  const { role } = auth.authState.userInfo;
  return (
    <section className="h-screen">
      <div className="w-16 sm:w-24 m-auto">
        <img src={logo} rel="logo" alt="Logo" />
      </div>
      <div className="mt-20">
        {navItems.map((navItem, i) => (
          <NavItemContainer key={i}>
            {navItem.allowedRoles.includes(role) && (
              <NavItem navItem={navItem} />
            )}
          </NavItemContainer>
        ))}
      </div>
    </section>
  );
};

export default Sidebar;
