package ren.nearby.home.net.exception


class ResultException(var errCode: String?, var msg: String?) : Exception(msg)
