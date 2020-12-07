#include <jni.h>
#include <string>

extern "C" JNIEXPORT jdouble JNICALL
Java_id_ac_ui_cs_mobileprogramming_farras_myfirstapp_MainActivity_add(
        JNIEnv *env,
        jobject,
        jdouble x,
        jdouble y) {
    return x+y;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_id_ac_ui_cs_mobileprogramming_farras_myfirstapp_MainActivity_subtract(
        JNIEnv *env,
        jobject,
        jdouble x,
        jdouble y) {
    return x-y;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_id_ac_ui_cs_mobileprogramming_farras_myfirstapp_MainActivity_multiply(
        JNIEnv *env,
        jobject,
        jdouble x,
        jdouble y) {
    return x*y;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_id_ac_ui_cs_mobileprogramming_farras_myfirstapp_MainActivity_divide(
        JNIEnv *env,
        jobject,
        jdouble x,
        jdouble y) {
    return x/y;
}
