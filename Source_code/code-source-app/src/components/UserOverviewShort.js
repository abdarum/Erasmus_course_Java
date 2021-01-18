import React, { useEffect, useContext } from 'react';
import { useTranslation } from "react-i18next";
import { getAuthorSelectOptions, getAuthorDatabaseValues } from './AuthorSelect';
import { getCommonNameSelectOptions, getCommonNameDatabaseValues } from './CommonNameSelect';
import { useHistory } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';
import qs from 'query-string';

const UserOverviewShort = ({
  userItem,
  userStatsEnabled,
  userIdVisible,
  registrationDateVisible
}) => {
  const { t } = useTranslation('common');
  const history = useHistory();
  const authContext = useContext(AuthContext);

  useEffect(() => {
    // console.log(userItem);
  }, []);

  const dumpUserInfo = {
    id: null,
    firstName: '',
    lastName: '',
    status: 'active',
    userTypeId: '',
    phone: '',
    email: '',
    password: '',
    birthdate: '',
    gender: '',
    address: '',
    city: ''
  };

  return (
    <div>
      <div className="flex items-center justify-between mb-2">
        <div className="flex">
          <p className="font-bold">{userItem.firstName} {userItem.lastName}</p>
        </div>
        <div className="flex">
          {userIdVisible ? (
            <p className="text-gray-600 text-sm mr-2">{t('components.user_overview_short_component.labels.user_id') + userItem.id}</p>
          ) : (<> </>)}
          {userItem.userTypeName ? (
            <p className="text-gray-600 text-sm rounded border border-blue-600 px-2 mr-2">{userItem.userTypeName}</p>
          ) : (<> </>)}
          <p className="text-gray-600 text-sm rounded border border-blue-600 px-2">{userItem.status}</p>
        </div>
      </div >
      <div className="flex items-center justify-between">
        <div className="flex items-center">
          <p className="text-gray-600 text-base text-left mr-1 font-bold">{t('components.user_overview_short_component.labels.phone')} </p>
          <p className="text-gray-600 text-base text-left">{userItem.phone} </p>
        </div>
        <div className="flex items-center">
          <p className="text-gray-600 text-base text-left mr-1 font-bold">{t('components.user_overview_short_component.labels.email')} </p>
          <p className="text-gray-600 text-base text-left">{userItem.email} </p>
        </div>
        {registrationDateVisible ? (
          <div className="flex items-center">
            <p className="text-gray-600 text-base text-left mr-1 font-bold">{t('components.user_overview_short_component.labels.registrated')} </p>
            <p className="text-gray-600 text-base text-left">{userItem.registrated} </p>
          </div>
        ) : (<> </>)}
      </div>
      <div className="flex items-center justify-between">
        <div className="flex items-center mr-2">
          <p className="text-gray-600 text-base text-left mr-1 font-bold">{t('components.user_overview_short_component.labels.birthdate')} </p>
          <p className="text-gray-600 text-base text-left">{userItem.birthdate} </p>
        </div>
        <div className="flex items-center">
          <p className="text-gray-600 text-base text-left mr-1 font-bold">{t('components.user_overview_short_component.labels.city')} </p>
          <p className="text-gray-600 text-base text-left">{userItem.city} </p>
        </div>
        <div className="flex items-center ml-2">
          <p className="text-gray-600 text-base text-left mr-1 font-bold">{t('components.user_overview_short_component.labels.address')} </p>
          <p className="text-gray-600 text-base text-left">{userItem.address} </p>
        </div>
      </div>
      {userStatsEnabled ? (
        <div className="rounded border border-blue-600 p-2 mr-1 ml-1 mt-3">
          <div className="flex items-center justify-between">
            <div className="flex items-center m-2 text-gray-600 text-base text-left">
              <p className="mr-1 font-bold">{t('components.user_overview_short_component.labels.number_of_all_borrowed_books')} </p>
              <p className="">{userItem.numberOfAllBorrowedBooks} </p>
            </div>
            <div className={"flex items-center m-2 text-base text-left " + (userItem.numberOfAllDamagedBooks > 0 ? "text-red-900" : "text-gray-600")}>
              <p className="mr-1 font-bold">{t('components.user_overview_short_component.labels.number_of_all_damaged_books')} </p>
              <p className="">{userItem.numberOfAllDamagedBooks} </p>
            </div>
            <div className={"flex items-center m-2 text-base text-left " + (userItem.numberOfCurrentBorrowedBooks > 0 ? "text-yellow-600" : "text-gray-600")}>
              <p className="mr-1 font-bold">{t('components.user_overview_short_component.labels.number_of_current_borrowed_books')} </p>
              <p className="">{userItem.numberOfCurrentBorrowedBooks} </p>
            </div>
            <div className={"flex items-center m-2 text-base text-left " + (userItem.numberOfAllDamagedBooks > 0 ? "text-red-500" : "text-gray-600")}>
              <p className="mr-1 font-bold">{t('components.user_overview_short_component.labels.number_of_delayed_books')} </p>
              <p className="">{userItem.numberOfDelayedBooks} </p>
            </div>
          </div>
          <div className="flex items-center justify-between">
            {userItem && userItem.currentBorrowed && !!userItem.currentBorrowed.length &&
              userItem.currentBorrowed.map(book => (
                <div className="flex rounded border border-yellow-600 p-2 m-1 text-sm ">
                  <p className="text-gray-600 text-left mr-1 font-bold">{t('components.user_overview_short_component.labels.book_id')} </p>
                  <p className="text-gray-600 text-left mr-2">{book.bookId} </p>
                  <p className="text-gray-600 text-left mr-1 font-bold">{t('components.user_overview_short_component.labels.book_name')} </p>
                  <p className="text-gray-600 text-left">{book.bookName} </p>
                </div>

              ))}
          </div>
        </div>
      ) : (<> </>)}
    </div >

  );
};

export default UserOverviewShort;
