import React, { useContext, useEffect, useState } from 'react';
import * as Yup from 'yup';
import { Formik, Form } from 'formik';
import Label from './common/Label';
import { useTranslation } from "react-i18next";
import FormInput from './FormInput';
import GradientButton from './common/GradientButton';
import { FetchContext } from '../context/FetchContext';
import { AuthContext } from '../context/AuthContext';
import Select from 'react-select';
import { getTeachingLanguagesSelectOptions, getTeachingLanguagesDatabaseValues } from './TeachingLanguagesSelect';
import { getEducationLevelSelectOptions, getEducationLevelDatabaseValues } from './EducationLevelSelect';
import { getFieldOfStudySelectOptions, getFieldOfStudyDatabaseValues } from './FieldOfStudySelect';
import qs from 'query-string';

const LessonItemFindFilterForm = ({ lessonItem, onChange }) => {
  const authContext = useContext(AuthContext);
  const fetchContext = useContext(FetchContext);
  const { t } = useTranslation('common');
  const [saveLoadingLessonItemForm, setSaveLoadingLessonItemForm] = useState(false);

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

  const dumpLessonItemFind = {
    fieldOfStudy: '',
    educationLevel: [authContext.authState.userInfo.educationLevel],
    hourlyRateMin: '',
    hourlyRateMax: '',
    teachingLanguages: []
  };

  useEffect(() => {
  }, []);

  const submitCredentialsLessonItemForm = async credentials => {
    try {
      var saveLessonItem = Object.assign({}, credentials);
      saveLessonItem.teachingLanguages = Object.assign([], getTeachingLanguagesDatabaseValues(credentials.teachingLanguages));
      saveLessonItem.educationLevel = Object.assign([], getEducationLevelDatabaseValues(credentials.educationLevel));
      if (lessonItem === undefined) {
        saveLessonItem.fieldOfStudy = getFieldOfStudyDatabaseValues(credentials.fieldOfStudy);
      }
      if (saveLessonItem.teachingLanguages.length === 0) {
        delete saveLessonItem.teachingLanguages;
      }
      if (saveLessonItem.educationLevel.length === 0) {
        delete saveLessonItem.educationLevel;
      }
      if (saveLessonItem.fieldOfStudy === "" || saveLessonItem.fieldOfStudy === undefined) {
        delete saveLessonItem.fieldOfStudy;
      }
      if (saveLessonItem.hourlyRateMin === 0 || saveLessonItem.hourlyRateMin === "") {
        delete saveLessonItem.hourlyRateMin;
      }
      if (saveLessonItem.hourlyRateMax === 0 || saveLessonItem.hourlyRateMax === "") {
        delete saveLessonItem.hourlyRateMax;
      }
      setSaveLoadingLessonItemForm(true);
      const { data } = await fetchContext.authAxios.get(
        `/v1/lessons?` + qs.stringify(saveLessonItem)
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
        initialValues={{
          fieldOfStudy: lessonItem !== undefined ? (lessonItem.fieldOfStudy !== undefined ? lessonItem.fieldOfStudy : dumpLessonItemFind.fieldOfStudy) : translateOptions(getFieldOfStudySelectOptions(dumpLessonItemFind.fieldOfStudy)),
          educationLevel: lessonItem !== undefined ? (translateOptions(getEducationLevelSelectOptions(lessonItem.educationLevel)) !== undefined ? translateOptions(getEducationLevelSelectOptions(lessonItem.educationLevel)) : translateOptions(getEducationLevelSelectOptions(dumpLessonItemFind.educationLevel))) : translateOptions(getEducationLevelSelectOptions(dumpLessonItemFind.educationLevel)),
          teachingLanguages: lessonItem !== undefined ? (translateOptions(getTeachingLanguagesSelectOptions(lessonItem.teachingLanguages)) !== undefined ? translateOptions(getTeachingLanguagesSelectOptions(lessonItem.teachingLanguages)) : translateOptions(getTeachingLanguagesSelectOptions(dumpLessonItemFind.teachingLanguages))) : translateOptions(getTeachingLanguagesSelectOptions(dumpLessonItemFind.teachingLanguages)),
          hourlyRateMin: lessonItem !== undefined ? (lessonItem.hourlyRateMin !== undefined ? lessonItem.hourlyRateMin : dumpLessonItemFind.hourlyRateMin) : dumpLessonItemFind.hourlyRateMin,
          hourlyRateMax: lessonItem !== undefined ? (lessonItem.hourlyRateMax !== undefined ? lessonItem.hourlyRateMax : dumpLessonItemFind.hourlyRateMax) : dumpLessonItemFind.hourlyRateMax
        }}
        onSubmit={values => {
          submitCredentialsLessonItemForm(values);
        }
        }
        validationSchema={SignupSchema}
      >
        {({ values, setFieldValue }) => (
          <Form className="">
            <div>
              <div className="flex">
                <div className="mb-2 mr-2 w-1/2">
                  <div className="mb-1">
                    <Label text={t('components.lesson_item_find_filter_form_component.forms.data.education_level')} />
                  </div>
                  <Select
                    name="educationLevel"
                    id="educationLevel"
                    isMulti
                    value={values.educationLevel}
                    options={translateOptions(getEducationLevelSelectOptions())}
                    onChange={(opt, e) => {
                      setFieldValue("educationLevel", opt);
                    }} />
                </div>
                <div className="mb-2 ml-2 w-1/2">
                  <div className="flex">
                    <div className="w-1/2 mr-2">
                      <div className="mb-1">
                        <Label text={t('components.lesson_item_find_filter_form_component.forms.data.hourly_rate_min')} />
                      </div>
                      <FormInput
                        ariaLabel={t('components.lesson_item_find_filter_form_component.forms.data.hourly_rate_min')}
                        name="hourlyRateMin"
                        type="number"
                        placeholder={t('components.lesson_item_find_filter_form_component.forms.data.hourly_rate_min')}
                      />
                    </div>
                    <div className="w-1/2 ml-2">
                      <div className="mb-1">
                        <Label text={t('components.lesson_item_find_filter_form_component.forms.data.hourly_rate_max')} />
                      </div>
                      <FormInput
                        ariaLabel={t('components.lesson_item_find_filter_form_component.forms.data.hourly_rate_max')}
                        name="hourlyRateMax"
                        type="number"
                        placeholder={t('components.lesson_item_find_filter_form_component.forms.data.hourly_rate_max')}
                      />
                    </div>
                  </div>
                </div>
              </div>
              <div className="flex">
                <div className="mb-2 mr-2 w-1/2">
                  <div className="mb-1">
                    <Label text={t('components.lesson_item_find_filter_form_component.forms.data.teaching_languages')} />
                  </div>
                  <Select
                    name="teachingLanguages"
                    id="teachingLanguages"
                    isMulti

                    value={values.teachingLanguages}
                    options={translateOptions(getTeachingLanguagesSelectOptions())}
                    onChange={(opt, e) => {
                      setFieldValue("teachingLanguages", opt);
                    }}
                  />
                </div>
                <div className="mb-2 ml-2 w-1/2 items-center">
                  <div className="flex">
                    <div className="w-2/3">
                      <div className="mb-1">
                        <Label text={t('components.lesson_item_find_filter_form_component.forms.data.field_of_study')} />
                      </div>
                      <Select
                        name="fieldOfStudy"
                        id="fieldOfStudy"
                        value={values.fieldOfStudy}
                        options={translateOptions(getFieldOfStudySelectOptions())}
                        onChange={(opt, e) => {
                          setFieldValue("fieldOfStudy", opt);
                        }} />
                    </div>
                    <div className="flex w-1/3 ml-5">
                      <GradientButton
                        type="submit"
                        text={t('components.lesson_item_find_filter_form_component.find_button')}
                        loading={saveLoadingLessonItemForm}
                      />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </Form>
        )}
      </Formik>
    </div >

  );
};

export default LessonItemFindFilterForm;
