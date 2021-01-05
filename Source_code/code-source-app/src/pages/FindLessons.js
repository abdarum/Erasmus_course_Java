import React, { useEffect, useState } from 'react';
import Card from '../components/common/Card';
import { useTranslation } from "react-i18next";
import LessonItemFindFilterForm from '../components/LessonItemFindFilter';
import LessonItemOverviewShort from '../components/LessonItemOverviewShort';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCompass, faSearch } from '@fortawesome/free-solid-svg-icons';

const FindLessons = () => {
  const { t } = useTranslation('common');
  const [foundLessonItems, setFoundLessonItems] = useState();
  const [beforeFirstSearch, setBeforeFirstSearch] = useState(true);

  useEffect(() => {

  }, []);

  return (
    <>
      <Card>
        <LessonItemFindFilterForm
          onChange={(data) => {
            setFoundLessonItems(data);
            console.log(data);
            setBeforeFirstSearch(false);
          }}
        />
      </Card>
      <br />
      { foundLessonItems && foundLessonItems.length
        ? foundLessonItems.map(item => (
          <div>
            <Card>
              <LessonItemOverviewShort
                lessonItem={item}
              />
            </Card>
            <br />
          </div>
        ))
        : (
          <div>
            {beforeFirstSearch ? (
              <p className='text-gray-700 text-3xl ml-3 mt-3'><FontAwesomeIcon icon={faCompass} /> {t('pages.find_lessons_page.set_filters_and_search')}</p>
            ) : (
                <p className='text-gray-700 text-3xl ml-3 mt-3'><FontAwesomeIcon icon={faSearch} /> {t('pages.find_lessons_page.no_lesson_items')}</p>
              )}
          </div>
        )}
    </>
  );
};

export default FindLessons;
