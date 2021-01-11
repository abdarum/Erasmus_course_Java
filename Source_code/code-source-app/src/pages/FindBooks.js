import React, { useEffect, useState, useContext } from 'react';
import Card from '../components/common/Card';
import { useTranslation } from "react-i18next";
import BooksFindFilterForm from '../components/BooksFindFilterForm';
import BookItemOverviewShort from '../components/BookItemOverviewShort';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCompass, faSearch } from '@fortawesome/free-solid-svg-icons';
import { FetchContext } from '../context/FetchContext';

const FindBooks = () => {
  const fetchContext = useContext(FetchContext);
  const { t } = useTranslation('common');
  const [foundBooks, setFoundBooks] = useState();
  const [beforeFirstSearch, setBeforeFirstSearch] = useState(true);
  const [authorsRaw, setAuthorsRaw] = useState([]);
  const [coverTypesRaw, setCoverTypesRaw] = useState([]);
  const [bookGenresRaw, setBookGenresRaw] = useState([]);
  const [borrowPeriodsRaw, setBorrowPeriodsRaw] = useState([]);
  const [borrowPlaceRaw, setBorrowPlaceRaw] = useState([]);

  useEffect(() => {
    const getCoverTypes = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          '/dataset/coverType'
        );
        setCoverTypesRaw(data);
      } catch (err) {
        console.log(err);
      }
    };
    const getAuthors = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          '/dataset/author'
        );
        setAuthorsRaw(data);
      } catch (err) {
        console.log(err);
      }
    };
    const getBookGenres = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          '/dataset/bookGenre'
        );
        setBookGenresRaw(data);
      } catch (err) {
        console.log(err);
      }
    };
    const getBorrowPeriods = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          '/dataset/borrowPeriod'
        );
        setBorrowPeriodsRaw(data);
      } catch (err) {
        console.log(err);
      }
    };
    const getBorrowPlace = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          '/dataset/borrowPlace'
        );
        setBorrowPlaceRaw(data);
      } catch (err) {
        console.log(err);
      }
    };
    getAuthors();
    getCoverTypes();
    getBookGenres();
    getBorrowPeriods();
    getBorrowPlace();

  }, []);

  return (
    <>
      <Card>
        <BooksFindFilterForm
          onChange={(data) => {
            setFoundBooks(data);
            console.log(data);
            setBeforeFirstSearch(false);
          }}
        />
      </Card>
      <br />
      { foundBooks && foundBooks.length
        ? foundBooks.map(item => (
          <div>
            <Card>
              <BookItemOverviewShort
                bookItem={item}
                authorsRawList={authorsRaw}
                coverTypesRawList={coverTypesRaw}
                bookGenresRawList={bookGenresRaw}
                borrowPeriodsRawList={borrowPeriodsRaw}
                borrowPlaceRawList={borrowPlaceRaw}
              />
            </Card>
            <br />
          </div>
        ))
        : (
          <div>
            {beforeFirstSearch ? (
              <p className='text-gray-700 text-3xl ml-3 mt-3'><FontAwesomeIcon icon={faCompass} /> {t('pages.find_books_page.set_filters_and_search')}</p>
            ) : (
                <p className='text-gray-700 text-3xl ml-3 mt-3'><FontAwesomeIcon icon={faSearch} /> {t('pages.find_books_page.no_books_found')}</p>
              )}
          </div>
        )}
    </>
  );
};

export default FindBooks;
