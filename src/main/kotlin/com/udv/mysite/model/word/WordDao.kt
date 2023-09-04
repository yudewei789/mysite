package com.udv.mysite.model.word

import com.udv.mysite.dao.BaseDao
import com.udv.mysite.model.Department
import com.udv.mysite.model.Departments
import org.springframework.stereotype.Component

/**
 * Created by vince on Jun 15, 2022.
 */
@Component
class WordDao : BaseDao<Word, Words>(Words)
