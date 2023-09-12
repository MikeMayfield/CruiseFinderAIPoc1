package com.tmf.cruisefinderaipoc1.tools

class HtmlText {
//    companion object {
//        fun fromHtml(value: String) : AnnotatedString {
//            if (value.contains('<')) {
//                val resultSb = StringBuilder()
//                val tokenSb = StringBuilder()
//                var parsingHtmlTag = false
//                var htmlTag = ""
//                var inTag = false
//
//                for (char in value) {
//                    when (char) {
//                        '<' -> {  //Start of opening or closing HTML tag
//                            tokenSb.clear()
//                            parsingHtmlTag = true
//                        }
//                        '>' -> {  //End of opening or closing HTML tag
//                            if (parsingHtmlTag) {
//                                htmlTag = tokenSb.toString()
//                                parsingHtmlTag = false
//                                inTag = true
//                            }
//                        }
//                        else -> tokenSb.append(char)
//                    }
//                }
//            }
//            else {
//                return AnnotatedString(value)
//            }
//        }
//    }
}