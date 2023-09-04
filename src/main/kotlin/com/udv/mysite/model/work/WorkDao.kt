package com.udv.mysite.model.word

import com.udv.mysite.dao.BaseDao
import org.springframework.stereotype.Component

/**
 * Created by vince on Jun 15, 2022.
 */
@Component
class WorkDao : BaseDao<Work, Works>(Works)
