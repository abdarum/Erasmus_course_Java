import React, { useContext, useEffect, useState } from 'react';
import * as Yup from 'yup';
import { Formik, Form, Field } from 'formik';
import FormSuccess from './FormSuccess';
import FormError from './FormError';
import Label from './common/Label';
import { useTranslation } from "react-i18next";
import FormInput from './FormInput';
import GradientButton from './common/GradientButton';
import DangerButton from './../components/common/DangerButton';
import { FetchContext } from '../context/FetchContext';
import { AuthContext } from '../context/AuthContext';
import Select from 'react-select';
import { getTeachingLanguagesSelectOptions, getTeachingLanguagesDatabaseValues } from './TeachingLanguagesSelect';
import { getEducationLevelSelectOptions, getEducationLevelDatabaseValues } from './EducationLevelSelect';
import { getFieldOfStudySelectOptions, getFieldOfStudyDatabaseValues } from './FieldOfStudySelect';

const LessonItemForm = ({ lessonItem }) => {
  const authContext = useContext(AuthContext);
  const fetchContext = useContext(FetchContext);
  const [saveSuccessLessonItemForm, setSaveSuccessLessonItemForm] = useState();
  const [saveErrorLessonItemForm, setSaveErrorLessonItemForm] = useState();
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

  const dumpLessonItem = {
    _id: undefined,
    teacherId: authContext.authState.userInfo._id, // get teacher id from logged in user
    fieldOfStudy: '',
    educationLevel: [authContext.authState.userInfo.educationLevel],
    teachingLanguages: [],
    hourlyRate: 0,
    onlineModeEnable: true,
    faceToFaceModeStudentPlaceEnable: true,
    faceToFaceModeTeacherPlaceEnable: true,
    places: [],
    description: ""
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

      setSaveLoadingLessonItemForm(true);
      const { data } = lessonItem === undefined ? (
        await fetchContext.authAxios.post(
          `/v1/lessons`,
          saveLessonItem
        )
      ) : (
          await fetchContext.authAxios.put(
            `/v1/lessons/` + saveLessonItem._id,
            saveLessonItem
          )
        );
      setSaveLoadingLessonItemForm(false);

      setSaveSuccessLessonItemForm(data.message);
      setSaveErrorLessonItemForm('');
      setTimeout(() => {
        window.location.reload();
      }, 700);
    } catch (error) {
      console.log(error);
      setSaveLoadingLessonItemForm(false);
      const { data } = error.response;
      setSaveErrorLessonItemForm(data.message);
      setSaveSuccessLessonItemForm('');
    }
  };

  const onDeleteLessonItemForm = async credentials => {
    try {
      if (
        window.confirm(t('components.lesson_item_form_component.do_you_want_delete_window'))
      ) {

        setSaveLoadingLessonItemForm(true);
        const { data } = await fetchContext.authAxios.delete(
          `/v1/lessons/` + lessonItem._id,
        );
        setSaveLoadingLessonItemForm(false);
        setSaveSuccessLessonItemForm(data.message);
        setSaveErrorLessonItemForm('');
        setTimeout(() => {
          window.location.reload();
        }, 700);
      }
    } catch (error) {
      console.log(error);
      setSaveLoadingLessonItemForm(false);
      const { data } = error.response;
      setSaveErrorLessonItemForm(data.message);
      setSaveSuccessLessonItemForm('');
    }
  };

  const SignupSchema = Yup.object().shape({
  });

  return (
    <div>
      <div className="flex">
        {lessonItem === undefined ? (
          <div />
        ) : (
            <div className="">
              <div className="flex items-center">
                <div className="mt-2 mb-2 mr-2">
                  <p className="font-bold">{t('datasets.field_of_study.values.' + lessonItem.fieldOfStudy)}</p>
                </div>
                <DangerButton
                  className="w-auto mt-2 mb-2 mr-2" style={{ marginLeft: "auto" }}
                  text={t('components.lesson_item_form_component.delete_button')}
                  onClick={() => onDeleteLessonItemForm()}
                />
              </div>
            </div>
          )
        }
      </div>
      <Formik
        initialValues={{
          _id: lessonItem !== undefined ? (lessonItem._id !== undefined ? lessonItem._id : dumpLessonItem._id) : dumpLessonItem._id,
          teacherId: lessonItem !== undefined ? (lessonItem.teacherId !== undefined ? lessonItem.teacherId : dumpLessonItem.teacherId) : dumpLessonItem.teacherId,
          fieldOfStudy: lessonItem !== undefined ? (lessonItem.fieldOfStudy !== undefined ? lessonItem.fieldOfStudy : dumpLessonItem.fieldOfStudy) : translateOptions(getFieldOfStudySelectOptions(dumpLessonItem.fieldOfStudy)),
          educationLevel: lessonItem !== undefined ? (translateOptions(getEducationLevelSelectOptions(lessonItem.educationLevel)) !== undefined ? translateOptions(getEducationLevelSelectOptions(lessonItem.educationLevel)) : translateOptions(getEducationLevelSelectOptions(dumpLessonItem.educationLevel))) : translateOptions(getEducationLevelSelectOptions(dumpLessonItem.educationLevel)),
          teachingLanguages: lessonItem !== undefined ? (translateOptions(getTeachingLanguagesSelectOptions(lessonItem.teachingLanguages)) !== undefined ? translateOptions(getTeachingLanguagesSelectOptions(lessonItem.teachingLanguages)) : translateOptions(getTeachingLanguagesSelectOptions(dumpLessonItem.teachingLanguages))) : translateOptions(getTeachingLanguagesSelectOptions(dumpLessonItem.teachingLanguages)),
          hourlyRate: lessonItem !== undefined ? (lessonItem.hourlyRate !== undefined ? lessonItem.hourlyRate : dumpLessonItem.hourlyRate) : dumpLessonItem.hourlyRate,
          onlineModeEnable: lessonItem !== undefined ? (lessonItem.onlineModeEnable !== undefined ? lessonItem.onlineModeEnable : dumpLessonItem.onlineModeEnable) : dumpLessonItem.onlineModeEnable,
          faceToFaceModeStudentPlaceEnable: lessonItem !== undefined ? (lessonItem.faceToFaceModeStudentPlaceEnable !== undefined ? lessonItem.faceToFaceModeStudentPlaceEnable : dumpLessonItem.faceToFaceModeStudentPlaceEnable) : dumpLessonItem.faceToFaceModeStudentPlaceEnable,
          faceToFaceModeTeacherPlaceEnable: lessonItem !== undefined ? (lessonItem.faceToFaceModeTeacherPlaceEnable !== undefined ? lessonItem.faceToFaceModeTeacherPlaceEnable : dumpLessonItem.faceToFaceModeTeacherPlaceEnable) : dumpLessonItem.faceToFaceModeTeacherPlaceEnable,
          places: lessonItem !== undefined ? (lessonItem.places !== undefined ? lessonItem.places : dumpLessonItem.places) : dumpLessonItem.places,
          description: lessonItem !== undefined ? (lessonItem.description !== undefined ? lessonItem.description : dumpLessonItem.description) : dumpLessonItem.description
        }}
        onSubmit={values => {
          submitCredentialsLessonItemForm(values);
        }
        }
        validationSchema={SignupSchema}
      >
        {({ values, setFieldValue }) => (
          <Form className="">
            {saveSuccessLessonItemForm && (
              <FormSuccess text={saveSuccessLessonItemForm + ' ' + t('components.lesson_item_form_component.some_data_visible_in_page_can_stay_unchanged')} />
            )}
            {saveErrorLessonItemForm && (
              <FormError text={saveErrorLessonItemForm} />
            )}
            <input
              type="hidden"
              name="remember"
              value="true"
            />
            <div>
              <div className="flex">
                {lessonItem === undefined ? (
                  <div className="mb-2 mt-2 w-1/2">
                    <Select
                      name="fieldOfStudy"
                      id="fieldOfStudy"
                      value={values.fieldOfStudy}
                      options={translateOptions(getFieldOfStudySelectOptions())}
                      onChange={(opt, e) => {
                        setFieldValue("fieldOfStudy", opt);
                      }} />
                  </div>
                ) : (
                    <div />
                  )
                }
              </div>

              <div className="flex">
                <div className="mb-2 mr-2 w-1/2">
                  <div className="mb-1">
                    <Label text={t('components.lesson_item_form_component.forms.data.education_level')} />
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
                  <div className="mb-1">
                    <Label text={t('components.lesson_item_form_component.forms.data.teaching_languages')} />
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
              </div>
              <div className="flex">
                <div className="mb-2 mr-2 w-1/2">
                  <div className="mb-1">
                    <Label text={t('components.lesson_item_form_component.forms.data.hourly_rate')} />
                  </div>
                  <FormInput
                    ariaLabel={t('components.lesson_item_form_component.forms.data.hourly_rate')}
                    name="hourlyRate"
                    type="number"
                    placeholder={t('components.lesson_item_form_component.forms.data.hourly_rate')}
                  />
                </div>
                <div className="mb-2 ml-2 w-1/2">
                  <div className="mb-1">
                    <Label text={t('components.lesson_item_form_component.forms.data.online_mode_enable_header')} />
                  </div>
                  <div className="flex">
                    <div className="">
                      <Field type="checkbox" name="onlineModeEnable" />
                    </div>
                    <div className="ml-2">
                      <Label text={t('components.lesson_item_form_component.forms.data.online_mode_enable_values.' + values.onlineModeEnable)} />
                    </div>
                  </div>
                </div>
              </div>
              <div className="flex">
                <div className="mb-2 mr-2 w-1/2">
                  <div className="mb-1">
                    <Label text={t('components.lesson_item_form_component.forms.data.face_to_face_mode_student_place_enable_header')} />
                  </div>
                  <div className="flex">
                    <div className="">
                      <Field type="checkbox" name="faceToFaceModeStudentPlaceEnable" />
                    </div>
                    <div className="ml-2">
                      <Label text={t('components.lesson_item_form_component.forms.data.face_to_face_mode_student_place_enable_values.' + values.faceToFaceModeStudentPlaceEnable)} />
                    </div>
                  </div>
                </div>
                <div className="mb-2 ml-2 w-1/2">
                  <div className="mb-1">
                    <Label text={t('components.lesson_item_form_component.forms.data.face_to_face_mode_teacher_place_enable_header')} />
                  </div>
                  <div className="flex">
                    <div className="">
                      <Field type="checkbox" name="faceToFaceModeTeacherPlaceEnable" />
                    </div>
                    <div className="ml-2">
                      <Label text={t('components.lesson_item_form_component.forms.data.face_to_face_mode_teacher_place_enable_values.' + values.faceToFaceModeTeacherPlaceEnable)} />
                    </div>
                  </div>
                </div>
              </div>
              <div className="flex">
                <div className="mb-2 mr-2 w-1/2">
                  <div className="mb-1">
                    <Label text={t('components.lesson_item_form_component.forms.data.places')} />
                  </div>
                  <Label text={t('others.warnings.sorry_not_implemented_yet')} />
                </div>
                <div className="mb-2 ml-2 w-1/2">
                  <div className="mb-1">
                    <Label text={t('components.lesson_item_form_component.forms.data.places')} />
                  </div>
                  <Label text={t('others.warnings.sorry_not_implemented_yet')} />
                </div>
              </div>
              <div className="flex">
                <div className="mb-2 mr-2 w-full">
                  <div className="mb-1">
                    <Label text={t('components.lesson_item_form_component.forms.data.description')} />
                  </div>
                  <Field
                    className="border border-gray-300 rounded p-2 w-full mb-2"
                    component="textarea"
                    name="description"
                    placeholder={t('components.lesson_item_form_component.forms.data.description_placeholder')}
                  />
                </div>
              </div>
            </div>
            <div className="flex items-center">
              <div className="mt-2 mb-2">
                <GradientButton
                  type="submit"
                  text={lessonItem === undefined ? t('components.lesson_item_form_component.add_new_item_button') : t('components.lesson_item_form_component.save_changes_button')}
                  loading={saveLoadingLessonItemForm}
                />
              </div>
            </div>

          </Form>
        )}
      </Formik>
    </div>

  );
};

export default LessonItemForm;
