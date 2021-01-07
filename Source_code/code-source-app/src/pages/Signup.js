import React, { useContext, useState } from 'react';
import { Form, Formik, Field } from 'formik';
import * as Yup from 'yup';
import Card from '../components/common/Card';
import GradientButton from '../components/common/GradientButton';
import Hyperlink from '../components/common/Hyperlink';
import Label from '../components/common/Label';
import Select from 'react-select';
import FormInput from '../components/FormInput';
import { AuthContext } from '../context/AuthContext';
import GradientBar from './../components/common/GradientBar';
import FormError from './../components/FormError';
import FormSuccess from './../components/FormSuccess';
import { publicFetch } from './../util/fetch';
import logo from './../images/logo.png';
import { Redirect } from 'react-router-dom';
import { useTranslation } from "react-i18next";
import DatePicker from 'react-date-picker';
import { getEducationLevelSelectOptions } from '../components/EducationLevelSelect';


const Signup = () => {
  const authContext = useContext(AuthContext);
  const [signupSuccess, setSignupSuccess] = useState();
  const [signupError, setSignupError] = useState();
  const [redirectOnLogin, setRedirectOnLogin] = useState(
    false
  );
  const [loginLoading, setLoginLoading] = useState(false);

  const { t } = useTranslation('common');

  function translateOptions(options) {
    options.forEach(function (entry) {
      if (entry.label !== undefined) {
        entry.label = t(entry.label);
      }
      if (entry.options !== undefined) {
        entry.options.forEach(function (entry) {
          if (entry.label !== undefined) {
            entry.label = t(entry.label);
          }
        });
      }
    });
    return options;
  }

  const SignupSchema = Yup.object().shape({
    firstName: Yup.string().required(
      t('pages.signup_page.forms.validation.first_name_is_required')
    ),
    lastName: Yup.string().required(t('pages.signup_page.forms.validation.last_name_is_required')),
    email: Yup.string()
      .email(t('pages.signup_page.forms.validation.invalid_email'))
      .required(t('pages.signup_page.forms.validation.email_is_required')),
    password: Yup.string().required(t('pages.signup_page.forms.validation.password_is_required'))
  });

  const submitCredentials = async credentials => {
    try {
      var saveLessonItem = Object.assign({}, credentials);

      setLoginLoading(true);
      const { data } = await publicFetch.post(
        `user`,
        saveLessonItem
      );

      setSignupSuccess(data.message);
      setSignupError('');

      // setTimeout(() => {
      setRedirectOnLogin(true);
      // }, 700);
    } catch (error) {
      setLoginLoading(false);
      const { data } = error.response;
      setSignupError(data.message);
      setSignupSuccess('');
    }
  };

  return (
    <>
      {redirectOnLogin && <Redirect to="/login" />}
      <section className="w-1/2 h-screen m-auto p-8 sm:pt-10">
        <GradientBar />
        <Card>
          <div className="flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
            <div className="max-w-md w-full">
              <div>
                <div className="w-32 m-auto mb-6">
                  <img src={logo} alt="Logo" />
                </div>
                <h2 className="mb-2 text-center text-3xl leading-9 font-extrabold text-gray-900">
                  {t('pages.signup_page.title')}
                </h2>
                <p className="text-gray-600 text-center">
                  {t('pages.signup_page.already_have_account')}{' '}
                  <Hyperlink to="login" text={t('pages.signup_page.log_in_now_link')} />
                </p>
              </div>
              <Formik
                // enableReinitialize
                initialValues={{
                  firstName: '',
                  lastName: '',
                  birthdate: new Date(),
                  gender: '',
                  address: '',
                  city: '',
                  phone: '',
                  email: '',
                  password: ''
                }}
                onSubmit={values => {
                  submitCredentials(values);
                }
                }
                validationSchema={SignupSchema}
              >
                {({ values, setFieldValue }) => (
                  <Form className="mt-8">
                    {signupSuccess && (
                      <FormSuccess text={signupSuccess} />
                    )}
                    {signupError && (
                      <FormError text={signupError} />
                    )}
                    <input
                      type="hidden"
                      name="remember"
                      value="true"
                    />
                    <div>
                      <div className="flex">
                        <div className="mb-2 mr-2 w-1/2">
                          <div className="mb-1">
                            <Label text={t('pages.signup_page.forms.basic_data.first_name')} />
                          </div>
                          <FormInput
                            ariaLabel={t('pages.signup_page.forms.basic_data.first_name')}
                            name="firstName"
                            type="text"
                            placeholder={t('pages.signup_page.forms.basic_data.first_name')}
                          />
                        </div>
                        <div className="mb-2 ml-2 w-1/2">
                          <div className="mb-1">
                            <Label text={t('pages.signup_page.forms.basic_data.last_name')} />
                          </div>
                          <FormInput
                            ariaLabel={t('pages.signup_page.forms.basic_data.last_name')}
                            name="lastName"
                            type="text"
                            placeholder={t('pages.signup_page.forms.basic_data.last_name')}
                          />
                        </div>
                      </div>
                      <div className="flex">
                        <div className="mb-2 mr-2 w-1/2">
                          <div className="mb-1">
                            <Label text={t('pages.signup_page.forms.basic_data.date_of_birth')} />
                          </div>
                          <DatePicker
                            onChange={
                              (value) => {
                                setFieldValue("birthdate", value);
                              }}
                            value={values.birthdate}
                          />
                        </div>
                        <div className="mb-2 ml-2 w-1/2">
                          <div className="mb-1">
                            <Label text={t('pages.signup_page.forms.basic_data.gender')} />
                          </div>
                          <div className="flex justify-between">
                            <p><Field type="radio" value="male" name="gender" /> {t('datasets.gender.values.male')}</p>
                            <p><Field type="radio" value="female" name="gender" /> {t('datasets.gender.values.female')}</p>
                            <p><Field type="radio" value="other" name="gender" /> {t('datasets.gender.values.other')}</p>
                          </div>
                        </div>
                      </div>
                      <div className="flex">
                        <div className="mb-2 mr-2 w-1/2">
                          <div className="mb-1">
                            <Label text={t('pages.signup_page.forms.basic_data.phone_number')} />
                          </div>
                          <FormInput
                            ariaLabel={t('pages.signup_page.forms.basic_data.phone_number')}
                            name="phone"
                            type="text"
                            placeholder={t('pages.signup_page.forms.basic_data.phone_number')}
                          />
                        </div>
                        <div className="mb-2 ml-2 w-1/2">

                        </div>
                      </div>
                      <div className="flex">
                        <div className="mb-2 mr-2 w-1/2">
                          <div className="mb-1">
                            <Label text={t('pages.signup_page.forms.basic_data.address')} />
                          </div>
                          <FormInput
                            ariaLabel={t('pages.signup_page.forms.basic_data.address')}
                            name="address"
                            type="text"
                            placeholder={t('pages.signup_page.forms.basic_data.address')}
                          />
                        </div>
                        <div className="mb-2 ml-2 w-1/2">
                          <div className="mb-1">
                            <Label text={t('pages.signup_page.forms.basic_data.city')} />
                          </div>
                          <FormInput
                            ariaLabel={t('pages.signup_page.forms.basic_data.city')}
                            name="city"
                            type="text"
                            placeholder={t('pages.signup_page.forms.basic_data.city')}
                          />
                        </div>
                      </div>
                      <div className="mb-2">
                        <div className="mb-1">
                          <Label text={t('pages.signup_page.forms.basic_data.email_address')} />
                        </div>
                        <FormInput
                          ariaLabel={t('pages.signup_page.forms.basic_data.email_address')}
                          name="email"
                          type="email"
                          placeholder={t('pages.signup_page.forms.basic_data.email_address')}
                        />
                      </div>
                      <div>
                        <div className="mb-1">
                          <Label text={t('pages.signup_page.forms.basic_data.password')} />
                        </div>
                        <FormInput
                          ariaLabel={t('pages.signup_page.forms.basic_data.password')}
                          name="password"
                          type="password"
                          placeholder={t('pages.signup_page.forms.basic_data.password')}
                        />
                      </div>
                    </div>

                    <div className="mt-6">
                      <GradientButton
                        type="submit"
                        text={t('pages.signup_page.sign_up_button')}
                        loading={loginLoading}
                      />
                    </div>
                  </Form>
                )}
              </Formik>
            </div>
          </div>
        </Card>
      </section>
    </>
  );
};

export default Signup;
