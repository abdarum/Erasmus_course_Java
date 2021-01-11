import React, { useEffect } from 'react';
import { useTranslation } from "react-i18next";
import { getAuthorSelectOptions, getAuthorDatabaseValues } from './AuthorSelect';
import { getCommonNameSelectOptions, getCommonNameDatabaseValues } from './CommonNameSelect';

const BookItemOverviewShort = ({
  bookItem,
  authorsRawList,
  coverTypesRawList,
  bookGenresRawList,
  borrowPeriodsRawList,
  borrowPlaceRawList
}) => {
  const { t } = useTranslation('common');

  useEffect(() => {
    // console.log(bookItem);
  }, []);

  const dumpBookItem = {
    id: '',
    name: '',
    isbn: '',
    authorId: '',
    pageCount: '',
    coverTypeId: '',
    genreId: '',
    sugeredPeriodId: '',
    sugeredPlaceId: '',
    status: ''
  };

  return (
    <div>
      <div className="flex items-center justify-between mb-2">
        <div className="">
          <p className="font-bold">{bookItem.name}</p>
        </div>
        <div className="flex">
          <p className="text-gray-600 text-sm rounded border border-blue-600 px-2">{bookItem.status}</p>
          <p className="text-gray-600 text-sm ml-1">{t('components.book_item_overview_short_component.labels.book_id_header') + bookItem.id}</p>
        </div>
      </div >
      <div className="flex items-center justify-between">
        <p className="text-gray-600 text-base text-left">{getAuthorSelectOptions(authorsRawList, bookItem.authorId) ? getAuthorSelectOptions(authorsRawList, bookItem.authorId).label : t('components.book_item_overview_short_component.labels.not_available')} </p>
      </div>
      <div className="flex items-center justify-between">
        <p className="text-gray-600 text-base text-left">{getCommonNameSelectOptions(bookGenresRawList, bookItem.genreId) ? getCommonNameSelectOptions(bookGenresRawList, bookItem.genreId).label : t('components.book_item_overview_short_component.labels.not_available')}</p>
      </div>
      <div className="flex items-center">
        <div className="flex items-center mr-3">
          <p className="text-gray-600 text-base text-left mr-1">{t('components.book_item_overview_short_component.labels.cover_type')}</p>
          <p className="text-gray-600 text-base text-left rounded border border-blue-600 px-2">{getCommonNameSelectOptions(coverTypesRawList, bookItem.coverTypeId) ? getCommonNameSelectOptions(coverTypesRawList, bookItem.coverTypeId).label : t('components.book_item_overview_short_component.labels.not_available')}</p>
        </div >
        <div className="flex items-center mr-3">
          <p className="text-gray-600 text-base text-left mr-1">{t('components.book_item_overview_short_component.labels.sugered_place')}</p>
          <p className="text-gray-600 text-base text-left mr-2 rounded border border-blue-600 px-2">{getCommonNameSelectOptions(borrowPlaceRawList, bookItem.sugeredPlaceId) ? getCommonNameSelectOptions(borrowPlaceRawList, bookItem.sugeredPlaceId).label : t('components.book_item_overview_short_component.labels.not_available')}</p>
        </div >
        <div className="flex items-center mr-3">
          <p className="text-gray-600 text-base text-left mr-1">{t('components.book_item_overview_short_component.labels.page_count')}</p>
          <p className="text-gray-600 text-base text-left rounded border border-blue-600 px-2">{bookItem.pageCount}</p>
        </div >

      </div >
    </div >

  );
};

export default BookItemOverviewShort;
