import React, { useEffect, useContext, useState } from 'react';
import { useTranslation } from "react-i18next";
import { getCommonNameSelectOptions, getCommonNameDatabaseValues } from './CommonNameSelect';
import { useHistory } from 'react-router-dom';
import BookItemOverviewShort from './BookItemOverviewShort';
import UserOverviewShort from './UserOverviewShort';
import { FetchContext } from '../context/FetchContext';
import { AuthContext } from '../context/AuthContext';
import qs from 'query-string';

const BorrowOverviewShort = ({
  orderItem,
  authorsRawList,
  coverTypesRawList,
  bookGenresRawList,
  borrowPeriodsRawList,
  borrowPlaceRawList,
  userIdNotVisible
}) => {
  const auth = useContext(AuthContext);
  const fetchContext = useContext(FetchContext);
  const { t } = useTranslation('common');
  const [book, setBook] = useState();
  const [user, setUser] = useState();
  const history = useHistory();
  const authContext = useContext(AuthContext);

  var queryValues = {
    token: auth.authState.token
  }

  const getBook = async (bookId) => {
    try {
      if (bookId) {
        const { data } = await fetchContext.authAxios.get(
          '/book/' + bookId + '?' + qs.stringify(queryValues)
        );
        setBook(data);
      }
    } catch (err) {
      console.log('the err', err);
      setBook();
    }
  };
  const getUser = async (userId) => {
    try {
      if (userId) {
        const { data } = await fetchContext.authAxios.get(
          '/user/' + userId + '?' + qs.stringify(queryValues)
        );
        setUser(data);
      }
    } catch (err) {
      console.log('the err', err);
      setUser();
    }
  };

  useEffect(() => {
    getBook(orderItem.bookId);
    if (!userIdNotVisible) {
      getUser(orderItem.userId);
    }
    // console.log(orderItem);
  }, []);

  const dumpUserInfo = {
    id: null,
    userId: null,
    bookId: null,
    placeId: null,
    periodId: null,
    borrowedDate: '',
    returnedDate: '',
    damageNotes: null
  };

  return (
    <div>
      <div className="flex items-center justify-between mb-2">
        <div className="">
          <p className="font-bold">{t('components.borrow_overview_short_component.labels.borrow') + orderItem.id}</p>
        </div>
        <button
          onClick={() => {
            var queryValues = {
              id: orderItem.id
            }
            history.push("/order?" + qs.stringify(queryValues));
          }}
          className={"text-sm rounded border px-2 hover:text-white " + (orderItem.returnedDate ? "text-blue-600 border-blue-600 hover:bg-blue-600" : "text-red-600 border-red-600 hover:bg-red-600")}
        >{orderItem.returnedDate ? t('components.borrow_overview_short_component.view_button') : t('components.borrow_overview_short_component.manage_button')}</button>
      </div >
      <div className="flex items-center justify-between">
        {userIdNotVisible ? (< ></>) : (
          <div className="flex items-center">
            <p className="text-gray-600 text-base text-left mr-1 font-bold">{t('components.borrow_overview_short_component.labels.user_id')} </p>
            <p className="text-gray-600 text-base text-left">{orderItem.userId} </p>
          </div>
        )}
        <div className="flex items-center">
          <p className="text-gray-600 text-base text-left mr-1 font-bold">{t('components.borrow_overview_short_component.labels.book_id')} </p>
          <p className="text-gray-600 text-base text-left">{orderItem.bookId} </p>
        </div>
      </div>
      <div className="flex items-center justify-between">
        {userIdNotVisible ? (< ></>) : (
          user ? (
            <div className="border border-green-300 rounded p-3 m-1 w-1/2">
              <UserOverviewShort userItem={user} />
            </div>
          ) : (< ></>)
        )}
        {book ? (
          <div className="border border-green-300 rounded p-3 m-1 w-1/2">
            <BookItemOverviewShort
              bookItem={book}
              authorsRawList={authorsRawList}
              coverTypesRawList={coverTypesRawList}
              bookGenresRawList={bookGenresRawList}
              borrowPeriodsRawList={borrowPeriodsRawList}
              borrowPlaceRawList={borrowPlaceRawList}
              borrowButtonDisabled
            />
          </div>
        ) : (< ></>)}
      </div>
      <div className="flex items-center justify-between">
        <div className="flex items-center">
          <p className="text-gray-600 text-base text-left mr-1 font-bold">{borrowPlaceRawList ? t('components.borrow_overview_short_component.labels.place_name') : t('components.borrow_overview_short_component.labels.place_id')} </p>
          <p className="text-gray-600 text-base text-left">{borrowPlaceRawList ? getCommonNameSelectOptions(borrowPlaceRawList, orderItem.placeId).label : orderItem.placeId} </p>
        </div>
        <div className="flex items-center">
          <p className="text-gray-600 text-base text-left mr-1 font-bold">{borrowPeriodsRawList ? t('components.borrow_overview_short_component.labels.period_name') : t('components.borrow_overview_short_component.labels.period_id')} </p>
          <p className="text-gray-600 text-base text-left">{borrowPeriodsRawList ? getCommonNameSelectOptions(borrowPeriodsRawList, orderItem.periodId).label : orderItem.periodId} </p>
        </div>
        <div className="flex items-center">
          <p className="text-gray-600 text-base text-left mr-1 font-bold">{t('components.borrow_overview_short_component.labels.borrowed_date')} </p>
          <p className="text-gray-600 text-base text-left">{orderItem.borrowedDate} </p>
        </div>
        {orderItem.returnedDate ? (
          <div className="flex items-center">
            <p className="text-gray-600 text-base text-left mr-1 font-bold">{t('components.borrow_overview_short_component.labels.returned_date')} </p>
            <p className="text-gray-600 text-base text-left">{orderItem.returnedDate} </p>
          </div>
        ) : (
            < ></>
          )}
      </div>
    </div >

  );
};

export default BorrowOverviewShort;
