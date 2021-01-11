import React, { useContext, useEffect, useState } from 'react';
import * as Yup from 'yup';
import { Formik, Form } from 'formik';
import Label from './common/Label';
import { useTranslation } from "react-i18next";
import FormInput from './FormInput';
import GradientButton from './common/GradientButton';
import { FetchContext } from '../context/FetchContext';
import { AuthContext } from '../context/AuthContext';
import qs from 'query-string';

const BooksFindFilterForm = ({ onChange }) => {
  const authContext = useContext(AuthContext);
  const fetchContext = useContext(FetchContext);
  const { t } = useTranslation('common');
  const [saveLoadingLessonItemForm, setSaveLoadingLessonItemForm] = useState(false);

  const dumpBooksFind = {
    title: ''
  };

  function prepareFormData(bookItem) {
    var processedBook = Object.assign({}, bookItem);
    return processedBook;
  }

  useEffect(() => {
  }, []);

  const submitCredentialsLessonItemForm = async credentials => {
    try {
      var saveBookItem = Object.assign({}, credentials);

      setSaveLoadingLessonItemForm(true);
      const { data } = await fetchContext.authAxios.get(
        `/book/findByStatus?` + qs.stringify(saveBookItem)
      );
      onChange(data);
      setSaveLoadingLessonItemForm(false);
    } catch (error) {
      console.log(error);
      setSaveLoadingLessonItemForm(false);
    }
  };

  const SignupSchema = Yup.object().shape({
  });

  return (
    <div>
      <Formik
        initialValues={prepareFormData(dumpBooksFind)}
        onSubmit={values => {
          submitCredentialsLessonItemForm(values);
        }
        }
        validationSchema={SignupSchema}
      >
        {({ values, setFieldValue }) => (
          <Form className="">
            <div>
              <div className="flex justify-between">
                <div className="w-2/3">
                  <div className="mb-1">
                    <Label text={t('components.books_find_filter_form_component.forms.data.title')} />
                  </div>
                  <FormInput
                    ariaLabel={t('components.books_find_filter_form_component.forms.data.title')}
                    name="title"
                    type="text"
                    placeholder={t('components.books_find_filter_form_component.forms.data.title')}
                  />
                </div>
                <div className="flex ml-5">
                  <GradientButton
                    type="submit"
                    text={t('components.books_find_filter_form_component.find_button')}
                    loading={saveLoadingLessonItemForm}
                  />
                </div>
              </div>
            </div>
          </Form>
        )}
      </Formik>
    </div >

  );
};

export default BooksFindFilterForm;
