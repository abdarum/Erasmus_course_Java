export const level1Options = [
    { value: 'pl_level1_group_1', label: 'Klasy 1-3' },
    { value: 'pl_level1_group_2', label: 'Klasy 4-8'},
];

export const level2Options = [
    { value: 'pl_level2_element_1', label: 'Nauka szkolna' },
    { value: 'pl_level2_element_2', label: 'Przygotowanie do matury' },
];

export const level3Options = [
    { value: 'pl_level3_element_1', label: 'Licencjat / Inżynier' },
    { value: 'pl_level3_element_2', label: 'Magister / Mgr. Inż' },
    { value: 'pl_level3_element_3', label: 'Doktorat' },
];

export const level4Options = [
    { value: 'pl_level4_element_1', label: 'Dorośli' },
];

export const groupedEducationLevel = [
    {
        label: 'Szkoła Podstawowa',
        options: level1Options,
    },
    {
        label: 'Szkoła średnia',
        options: level2Options,
    },
    {
        label: 'Szkolnictwo wyższe',
        options: level3Options,
    },
    {
        label: 'Inne',
        options: level4Options,
    },
];
