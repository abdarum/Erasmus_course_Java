import React, {
  useContext,
  useEffect,
  useState
} from 'react';
import PageTitle from '../components/common/PageTitle';
import { FetchContext } from '../context/FetchContext';
import { formatCurrency } from '../util';
import OrderForm from '../components/OrderForm';
import DangerButton from '../components/common/DangerButton';
import FormError from '../components/FormError';
import FormSuccess from '../components/FormSuccess';
import qs from 'query-string';
import { AuthContext } from '../context/AuthContext';


const Order = () => {
  const fetchContext = useContext(FetchContext);
  const [order, setOrder] = useState();
  const [successMessage, setSuccessMessage] = useState();
  const [errorMessage, setErrorMessage] = useState();
  const auth = useContext(AuthContext);


  const dumpOrderItem = Object.assign({
    id: '',
    userId: '',
    bookId: '',
    damageNotes: '',
    placeId: '',
    periodId: ''
  }, qs.parse(window.location.search));

  useEffect(() => {
    // console.log(qs.parse(window.location.search));
    // dumpOrderItem = Object.assign(dumpOrderItem, qs.parse(window.location.search));
    var queryValues = {
      token: auth.authState.token
    }
    const getOrder = async () => {
      try {
        if (qs.parse(window.location.search).id) {
          const { data } = await fetchContext.authAxios.get(
            '/library/order/' + qs.parse(window.location.search).id + '?' + qs.stringify(queryValues)
          );
          setOrder(data);
          console.log(data);
        } else {
          console.log(dumpOrderItem);
          setOrder(dumpOrderItem);
        }
      } catch (err) {
        console.log('the err', err);
      }
    };


    getOrder();
  }, [fetchContext]);

  return (
    <>
      <PageTitle title="Order" />
      {order ? (
        <></>
      ) : (
          <OrderForm
            orderItem={order}
          />
        )}

    </>
  );
};

export default Order;
