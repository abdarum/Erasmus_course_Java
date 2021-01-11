import React, {
  useContext,
  useEffect,
  useState
} from 'react';
import PageTitle from '../components/common/PageTitle';
import { FetchContext } from '../context/FetchContext';
import Card from '../components/common/Card';
import BookFullDetailsForm from '../components/BookFullDetailsForm';
import { AuthContext } from './../context/AuthContext';
import qs from 'query-string';
import { useTranslation } from "react-i18next";

const ManageBooks = () => {
  const fetchContext = useContext(FetchContext);
  const [books, setBooks] = useState([]);
  const [authorsRaw, setAuthorsRaw] = useState([]);
  const [coverTypesRaw, setCoverTypesRaw] = useState([]);
  const [bookGenresRaw, setBookGenresRaw] = useState([]);
  const [borrowPeriodsRaw, setBorrowPeriodsRaw] = useState([]);
  const [borrowPlaceRaw, setBorrowPlaceRaw] = useState([]);
  const auth = useContext(AuthContext);
  const { t } = useTranslation('common');

  useEffect(() => {
    var queryValues = {
      token: auth.authState.token
    }
    const getBooks = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          '/book?' + qs.stringify(queryValues)
        );
        setBooks(data);
      } catch (err) {
        console.log(err);
      }
    };
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
    getBooks();
    getAuthors();
    getCoverTypes();
    getBookGenres();
    getBorrowPeriods();
    getBorrowPlace();
  }, [fetchContext.authAxios]);

  return (
    <>
      <PageTitle title={t('pages.manage_books_page.title')} />
      <div className="flex flex-col">
        <Card>
          <BookFullDetailsForm
            authorsRawList={authorsRaw}
            coverTypesRawList={coverTypesRaw}
            bookGenresRawList={bookGenresRaw}
            borrowPeriodsRawList={borrowPeriodsRaw}
            borrowPlaceRawList={borrowPlaceRaw}
          />
        </Card>
        {!!books.length &&
          books.map(book => (
            <div className="m-2">
              <Card>
                <BookFullDetailsForm key={book._id} book={book}
                  authorsRawList={authorsRaw}
                  coverTypesRawList={coverTypesRaw}
                  bookGenresRawList={bookGenresRaw}
                  borrowPeriodsRawList={borrowPeriodsRaw}
                  borrowPlaceRawList={borrowPlaceRaw}
                />
              </Card>
            </div>
          ))}
      </div>
    </>
  );
};

export default ManageBooks;
