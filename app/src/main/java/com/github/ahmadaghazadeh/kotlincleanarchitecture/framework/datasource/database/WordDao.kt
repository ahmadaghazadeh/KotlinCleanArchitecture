package com.github.ahmadaghazadeh.kotlincleanarchitecture.framework.datasource.database

const val WORD_ORDER_ASC: String = ""
const val WORD_ORDER_DESC: String = "-"
const val WORD_FILTER_TITLE = "title"
const val WORD_FILTER_DATE_CREATED = "created_at"

const val ORDER_BY_ASC_DATE_UPDATED = WORD_ORDER_ASC + WORD_FILTER_DATE_CREATED
const val ORDER_BY_DESC_DATE_UPDATED = WORD_ORDER_DESC + WORD_FILTER_DATE_CREATED
const val ORDER_BY_ASC_TITLE = WORD_ORDER_ASC + WORD_FILTER_TITLE
const val ORDER_BY_DESC_TITLE = WORD_ORDER_DESC + WORD_FILTER_TITLE

const val WORD_PAGINATION_PAGE_SIZE = 30