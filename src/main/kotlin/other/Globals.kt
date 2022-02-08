package other

import java.text.SimpleDateFormat
import java.util.*

fun commonAnnotation(provider: ArmsPluginTemplateProviderImpl) = """
/**
 * Created on ${SimpleDateFormat("yyyy/MM/dd HH:mm").format(Date(System.currentTimeMillis()))}
 * @author  
 * @description 
 */
""".trimIndent()

val armsAnnotation = """
/**
 * ================================================
 * Description:
 * <p>
 * Created by mvp on ${SimpleDateFormat("yyyy/MM/dd HH:mm").format(Date(System.currentTimeMillis()))}
 * ================================================
 */
""".trimIndent()