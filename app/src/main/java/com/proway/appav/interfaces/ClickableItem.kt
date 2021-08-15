package com.proway.appav.interfaces

import com.proway.appav.model.Products

interface ClickableItem {

        fun onClickGoToDetail(products: Products)
    }
