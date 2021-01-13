import React, {
  useContext,
  useEffect,
  useState
} from 'react';
import PageTitle from '../components/common/PageTitle';
import { FetchContext } from '../context/FetchContext';
import Card from '../components/common/Card';
import BorrowOverviewShort from '../components/BorrowOverviewShort';
import { AuthContext } from './../context/AuthContext';
import qs from 'query-string';
import { useTranslation } from "react-i18next";

const ManageOrders = () => {
  const fetchContext = useContext(FetchContext);
  const [orders, setOrders] = useState([]);
  const [authorsRaw, setAuthorsRaw] = useState([]);
  const [coverTypesRaw, setCoverTypesRaw] = useState([]);
  const [bookGenresRaw, setBookGenresRaw] = useState([]);
  const [borrowPeriodsRaw, setBorrowPeriodsRaw] = useState([]);
  const [borrowPlaceRaw, setBorrowPlaceRaw] = useState([]);
  const auth = useContext(AuthContext);
  const { t } = useTranslation('common');

  var queryValues = {
    token: auth.authState.token
  }

  const getOrders = async () => {
    try {
      const { data } = await fetchContext.authAxios.get(
        '/library/order?' + qs.stringify(queryValues)
      );
      setOrders(data);
    } catch (err) {
      console.log('the err', err);
      setOrders();
    }
  };

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

    getOrders();
  }, [fetchContext.authAxios]);

  return (
    <>
      <PageTitle title={t('pages.manage_orders_page.title')} />
      <div className="flex flex-col">
        {!!orders.length &&
          orders.map(order => (
            <div className="m-2">
              <Card>
                <BorrowOverviewShort orderItem={order}
                  authorsRawList={authorsRaw}
                  coverTypesRawList={coverTypesRaw}
                  bookGenresRawList={bookGenresRaw}
                  borrowPeriodsRawList={borrowPeriodsRaw}
                  borrowPlaceRawList={borrowPlaceRaw}
                  userIdNotVisible={auth.isReader()}
                />
              </Card>
            </div>
          ))}
      </div>
    </>
  );
};

export default ManageOrders;
