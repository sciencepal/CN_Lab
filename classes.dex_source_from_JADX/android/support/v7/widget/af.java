package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.C0325e;
import android.support.v4.view.ag;
import android.support.v7.p013b.C0509a.C0508k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: LinearLayoutCompat */
public class af extends ViewGroup {
    private boolean f1273a;
    private int f1274b;
    private int f1275c;
    private int f1276d;
    private int f1277e;
    private int f1278f;
    private float f1279g;
    private boolean f1280h;
    private int[] f1281i;
    private int[] f1282j;
    private Drawable f1283k;
    private int f1284l;
    private int f1285m;
    private int f1286n;
    private int f1287o;

    /* compiled from: LinearLayoutCompat */
    public static class C0563a extends MarginLayoutParams {
        public float f1264g;
        public int f1265h;

        public C0563a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1265h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0508k.LinearLayoutCompat_Layout);
            this.f1264g = obtainStyledAttributes.getFloat(C0508k.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f1265h = obtainStyledAttributes.getInt(C0508k.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public C0563a(int i, int i2) {
            super(i, i2);
            this.f1265h = -1;
            this.f1264g = 0.0f;
        }

        public C0563a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1265h = -1;
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return mo525j();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return mo519b(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return mo520b(layoutParams);
    }

    public af(Context context) {
        this(context, null);
    }

    public af(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public af(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1273a = true;
        this.f1274b = -1;
        this.f1275c = 0;
        this.f1277e = 8388659;
        ar a = ar.m2940a(context, attributeSet, C0508k.LinearLayoutCompat, i, 0);
        int a2 = a.m2942a(C0508k.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.m2942a(C0508k.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.m2945a(C0508k.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.f1279g = a.m2941a(C0508k.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1274b = a.m2942a(C0508k.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1280h = a.m2945a(C0508k.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.m2943a(C0508k.LinearLayoutCompat_divider));
        this.f1286n = a.m2942a(C0508k.LinearLayoutCompat_showDividers, 0);
        this.f1287o = a.m2952e(C0508k.LinearLayoutCompat_dividerPadding, 0);
        a.m2944a();
    }

    public void setShowDividers(int i) {
        if (i != this.f1286n) {
            requestLayout();
        }
        this.f1286n = i;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.f1286n;
    }

    public Drawable getDividerDrawable() {
        return this.f1283k;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.f1283k) {
            this.f1283k = drawable;
            if (drawable != null) {
                this.f1284l = drawable.getIntrinsicWidth();
                this.f1285m = drawable.getIntrinsicHeight();
            } else {
                this.f1284l = 0;
                this.f1285m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f1287o = i;
    }

    public int getDividerPadding() {
        return this.f1287o;
    }

    public int getDividerWidth() {
        return this.f1284l;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f1283k != null) {
            if (this.f1276d == 1) {
                m2651a(canvas);
            } else {
                m2660b(canvas);
            }
        }
    }

    void m2651a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = m2657b(i);
            if (!(b == null || b.getVisibility() == 8 || !m2662c(i))) {
                m2652a(canvas, (b.getTop() - ((C0563a) b.getLayoutParams()).topMargin) - this.f1285m);
            }
            i++;
        }
        if (m2662c(virtualChildCount)) {
            int height;
            View b2 = m2657b(virtualChildCount - 1);
            if (b2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.f1285m;
            } else {
                C0563a c0563a = (C0563a) b2.getLayoutParams();
                height = c0563a.bottomMargin + b2.getBottom();
            }
            m2652a(canvas, height);
        }
    }

    void m2660b(Canvas canvas) {
        C0563a c0563a;
        int virtualChildCount = getVirtualChildCount();
        boolean a = au.m3012a(this);
        int i = 0;
        while (i < virtualChildCount) {
            int right;
            View b = m2657b(i);
            if (!(b == null || b.getVisibility() == 8 || !m2662c(i))) {
                c0563a = (C0563a) b.getLayoutParams();
                if (a) {
                    right = c0563a.rightMargin + b.getRight();
                } else {
                    right = (b.getLeft() - c0563a.leftMargin) - this.f1284l;
                }
                m2661b(canvas, right);
            }
            i++;
        }
        if (m2662c(virtualChildCount)) {
            View b2 = m2657b(virtualChildCount - 1);
            if (b2 != null) {
                c0563a = (C0563a) b2.getLayoutParams();
                if (a) {
                    right = (b2.getLeft() - c0563a.leftMargin) - this.f1284l;
                } else {
                    right = c0563a.rightMargin + b2.getRight();
                }
            } else if (a) {
                right = getPaddingLeft();
            } else {
                right = (getWidth() - getPaddingRight()) - this.f1284l;
            }
            m2661b(canvas, right);
        }
    }

    void m2652a(Canvas canvas, int i) {
        this.f1283k.setBounds(getPaddingLeft() + this.f1287o, i, (getWidth() - getPaddingRight()) - this.f1287o, this.f1285m + i);
        this.f1283k.draw(canvas);
    }

    void m2661b(Canvas canvas, int i) {
        this.f1283k.setBounds(i, getPaddingTop() + this.f1287o, this.f1284l + i, (getHeight() - getPaddingBottom()) - this.f1287o);
        this.f1283k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.f1273a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f1280h = z;
    }

    public int getBaseline() {
        if (this.f1274b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f1274b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f1274b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.f1275c;
            if (this.f1276d == 1) {
                i = this.f1277e & 112;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1278f) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1278f;
                            break;
                    }
                }
            }
            i = i2;
            return (((C0563a) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.f1274b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1274b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f1274b = i;
    }

    View m2657b(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1279g;
    }

    public void setWeightSum(float f) {
        this.f1279g = Math.max(0.0f, f);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1276d == 1) {
            m2649a(i, i2);
        } else {
            m2658b(i, i2);
        }
    }

    protected boolean m2662c(int i) {
        if (i == 0) {
            if ((this.f1286n & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.f1286n & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.f1286n & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    void m2649a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        View b;
        this.f1278f = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj2 = null;
        Object obj3 = null;
        int i10 = this.f1274b;
        boolean z = this.f1280h;
        int i11 = Integer.MIN_VALUE;
        int i12 = 0;
        while (i12 < virtualChildCount) {
            Object obj4;
            Object obj5;
            int i13;
            View b2 = m2657b(i12);
            if (b2 == null) {
                this.f1278f += m2663d(i12);
                i3 = i11;
                obj4 = obj3;
                obj5 = obj;
                i4 = i7;
                i13 = i6;
            } else if (b2.getVisibility() == 8) {
                i12 += m2648a(b2, i12);
                i3 = i11;
                obj4 = obj3;
                obj5 = obj;
                i4 = i7;
                i13 = i6;
            } else {
                if (m2662c(i12)) {
                    this.f1278f += this.f1285m;
                }
                C0563a c0563a = (C0563a) b2.getLayoutParams();
                float f2 = f + c0563a.f1264g;
                if (mode2 == 1073741824 && c0563a.height == 0 && c0563a.f1264g > 0.0f) {
                    i3 = this.f1278f;
                    this.f1278f = Math.max(i3, (c0563a.topMargin + i3) + c0563a.bottomMargin);
                    obj3 = 1;
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (c0563a.height == 0 && c0563a.f1264g > 0.0f) {
                        i3 = 0;
                        c0563a.height = -2;
                    }
                    int i14 = i3;
                    m2653a(b2, i12, i, 0, i2, f2 == 0.0f ? this.f1278f : 0);
                    if (i14 != Integer.MIN_VALUE) {
                        c0563a.height = i14;
                    }
                    i3 = b2.getMeasuredHeight();
                    int i15 = this.f1278f;
                    this.f1278f = Math.max(i15, (((i15 + i3) + c0563a.topMargin) + c0563a.bottomMargin) + m2654b(b2));
                    if (z) {
                        i11 = Math.max(i3, i11);
                    }
                }
                if (i10 >= 0 && i10 == i12 + 1) {
                    this.f1275c = this.f1278f;
                }
                if (i12 >= i10 || c0563a.f1264g <= 0.0f) {
                    Object obj6;
                    Object obj7 = null;
                    if (mode == 1073741824 || c0563a.width != -1) {
                        obj6 = obj2;
                    } else {
                        obj6 = 1;
                        obj7 = 1;
                    }
                    i4 = c0563a.rightMargin + c0563a.leftMargin;
                    i13 = b2.getMeasuredWidth() + i4;
                    i6 = Math.max(i6, i13);
                    int a = au.m3010a(i7, ag.m1285g(b2));
                    obj5 = (obj == null || c0563a.width != -1) ? null : 1;
                    if (c0563a.f1264g > 0.0f) {
                        if (obj7 != null) {
                            i3 = i4;
                        } else {
                            i3 = i13;
                        }
                        i3 = Math.max(i9, i3);
                        i4 = i8;
                    } else {
                        if (obj7 == null) {
                            i4 = i13;
                        }
                        i4 = Math.max(i8, i4);
                        i3 = i9;
                    }
                    i12 += m2648a(b2, i12);
                    obj4 = obj3;
                    i9 = i3;
                    i8 = i4;
                    i13 = i6;
                    i3 = i11;
                    i4 = a;
                    obj2 = obj6;
                    f = f2;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i12++;
            i11 = i3;
            obj3 = obj4;
            obj = obj5;
            i7 = i4;
            i6 = i13;
        }
        if (this.f1278f > 0 && m2662c(virtualChildCount)) {
            this.f1278f += this.f1285m;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f1278f = 0;
            i5 = 0;
            while (i5 < virtualChildCount) {
                b = m2657b(i5);
                if (b == null) {
                    this.f1278f += m2663d(i5);
                    i3 = i5;
                } else if (b.getVisibility() == 8) {
                    i3 = m2648a(b, i5) + i5;
                } else {
                    C0563a c0563a2 = (C0563a) b.getLayoutParams();
                    int i16 = this.f1278f;
                    this.f1278f = Math.max(i16, (c0563a2.bottomMargin + ((i16 + i11) + c0563a2.topMargin)) + m2654b(b));
                    i3 = i5;
                }
                i5 = i3 + 1;
            }
        }
        this.f1278f += getPaddingTop() + getPaddingBottom();
        int a2 = ag.m1258a(Math.max(this.f1278f, getSuggestedMinimumHeight()), i2, 0);
        i5 = (16777215 & a2) - this.f1278f;
        int i17;
        if (obj3 != null || (i5 != 0 && f > 0.0f)) {
            if (this.f1279g > 0.0f) {
                f = this.f1279g;
            }
            this.f1278f = 0;
            i11 = 0;
            float f3 = f;
            Object obj8 = obj;
            i17 = i8;
            i16 = i7;
            i9 = i6;
            i15 = i5;
            while (i11 < virtualChildCount) {
                View b3 = m2657b(i11);
                if (b3.getVisibility() == 8) {
                    i3 = i17;
                    i5 = i16;
                    i4 = i9;
                    obj5 = obj8;
                } else {
                    float f4;
                    float f5;
                    c0563a2 = (C0563a) b3.getLayoutParams();
                    float f6 = c0563a2.f1264g;
                    if (f6 > 0.0f) {
                        i5 = (int) ((((float) i15) * f6) / f3);
                        f3 -= f6;
                        i15 -= i5;
                        i4 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + c0563a2.leftMargin) + c0563a2.rightMargin, c0563a2.width);
                        if (c0563a2.height == 0 && mode2 == 1073741824) {
                            if (i5 <= 0) {
                                i5 = 0;
                            }
                            b3.measure(i4, MeasureSpec.makeMeasureSpec(i5, 1073741824));
                        } else {
                            i5 += b3.getMeasuredHeight();
                            if (i5 < 0) {
                                i5 = 0;
                            }
                            b3.measure(i4, MeasureSpec.makeMeasureSpec(i5, 1073741824));
                        }
                        f4 = f3;
                        i12 = i15;
                        i15 = au.m3010a(i16, ag.m1285g(b3) & -256);
                        f5 = f4;
                    } else {
                        f5 = f3;
                        i12 = i15;
                        i15 = i16;
                    }
                    i16 = c0563a2.leftMargin + c0563a2.rightMargin;
                    i4 = b3.getMeasuredWidth() + i16;
                    i9 = Math.max(i9, i4);
                    Object obj9 = (mode == 1073741824 || c0563a2.width != -1) ? null : 1;
                    if (obj9 == null) {
                        i16 = i4;
                    }
                    i4 = Math.max(i17, i16);
                    obj5 = (obj8 == null || c0563a2.width != -1) ? null : 1;
                    i13 = this.f1278f;
                    this.f1278f = Math.max(i13, (c0563a2.bottomMargin + ((b3.getMeasuredHeight() + i13) + c0563a2.topMargin)) + m2654b(b3));
                    i3 = i4;
                    i4 = i9;
                    f4 = f5;
                    i5 = i15;
                    i15 = i12;
                    f3 = f4;
                }
                i11++;
                i17 = i3;
                i9 = i4;
                obj8 = obj5;
                i16 = i5;
            }
            this.f1278f += getPaddingTop() + getPaddingBottom();
            obj = obj8;
            i3 = i17;
            i7 = i16;
            i5 = i9;
        } else {
            i17 = Math.max(i8, i9);
            if (z && mode2 != 1073741824) {
                for (i5 = 0; i5 < virtualChildCount; i5++) {
                    b = m2657b(i5);
                    if (!(b == null || b.getVisibility() == 8 || ((C0563a) b.getLayoutParams()).f1264g <= 0.0f)) {
                        b.measure(MeasureSpec.makeMeasureSpec(b.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i11, 1073741824));
                    }
                }
            }
            i3 = i17;
            i5 = i6;
        }
        if (obj != null || mode == 1073741824) {
            i3 = i5;
        }
        setMeasuredDimension(ag.m1258a(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i7), a2);
        if (obj2 != null) {
            m2645c(virtualChildCount, i2);
        }
    }

    private void m2645c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m2657b(i3);
            if (b.getVisibility() != 8) {
                C0563a c0563a = (C0563a) b.getLayoutParams();
                if (c0563a.width == -1) {
                    int i4 = c0563a.height;
                    c0563a.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    c0563a.height = i4;
                }
            }
        }
    }

    void m2658b(int i, int i2) {
        Object obj;
        int i3;
        int i4;
        C0563a c0563a;
        this.f1278f = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        if (this.f1281i == null || this.f1282j == null) {
            this.f1281i = new int[4];
            this.f1282j = new int[4];
        }
        int[] iArr = this.f1281i;
        int[] iArr2 = this.f1282j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.f1273a;
        boolean z2 = this.f1280h;
        if (mode == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int i9 = Integer.MIN_VALUE;
        int i10 = 0;
        while (i10 < virtualChildCount) {
            Object obj5;
            Object obj6;
            int i11;
            int i12;
            View b = m2657b(i10);
            if (b == null) {
                this.f1278f += m2663d(i10);
                i3 = i9;
                obj5 = obj4;
                obj6 = obj2;
                i11 = i6;
                i12 = i5;
            } else if (b.getVisibility() == 8) {
                i10 += m2648a(b, i10);
                i3 = i9;
                obj5 = obj4;
                obj6 = obj2;
                i11 = i6;
                i12 = i5;
            } else {
                Object obj7;
                if (m2662c(i10)) {
                    this.f1278f += this.f1284l;
                }
                C0563a c0563a2 = (C0563a) b.getLayoutParams();
                float f2 = f + c0563a2.f1264g;
                if (mode == 1073741824 && c0563a2.width == 0 && c0563a2.f1264g > 0.0f) {
                    if (obj != null) {
                        this.f1278f += c0563a2.leftMargin + c0563a2.rightMargin;
                    } else {
                        i3 = this.f1278f;
                        this.f1278f = Math.max(i3, (c0563a2.leftMargin + i3) + c0563a2.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(i3, i3);
                    } else {
                        obj4 = 1;
                    }
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (c0563a2.width == 0 && c0563a2.f1264g > 0.0f) {
                        i3 = 0;
                        c0563a2.width = -2;
                    }
                    int i13 = i3;
                    m2653a(b, i10, i, f2 == 0.0f ? this.f1278f : 0, i2, 0);
                    if (i13 != Integer.MIN_VALUE) {
                        c0563a2.width = i13;
                    }
                    i3 = b.getMeasuredWidth();
                    if (obj != null) {
                        this.f1278f += ((c0563a2.leftMargin + i3) + c0563a2.rightMargin) + m2654b(b);
                    } else {
                        int i14 = this.f1278f;
                        this.f1278f = Math.max(i14, (((i14 + i3) + c0563a2.leftMargin) + c0563a2.rightMargin) + m2654b(b));
                    }
                    if (z2) {
                        i9 = Math.max(i3, i9);
                    }
                }
                Object obj8 = null;
                if (mode2 == 1073741824 || c0563a2.height != -1) {
                    obj7 = obj3;
                } else {
                    obj7 = 1;
                    obj8 = 1;
                }
                i11 = c0563a2.bottomMargin + c0563a2.topMargin;
                i12 = b.getMeasuredHeight() + i11;
                int a = au.m3010a(i6, ag.m1285g(b));
                if (z) {
                    i6 = b.getBaseline();
                    if (i6 != -1) {
                        int i15 = ((((c0563a2.f1265h < 0 ? this.f1277e : c0563a2.f1265h) & 112) >> 4) & -2) >> 1;
                        iArr[i15] = Math.max(iArr[i15], i6);
                        iArr2[i15] = Math.max(iArr2[i15], i12 - i6);
                    }
                }
                i6 = Math.max(i5, i12);
                obj6 = (obj2 == null || c0563a2.height != -1) ? null : 1;
                if (c0563a2.f1264g > 0.0f) {
                    if (obj8 != null) {
                        i3 = i11;
                    } else {
                        i3 = i12;
                    }
                    i3 = Math.max(i8, i3);
                    i11 = i7;
                } else {
                    if (obj8 == null) {
                        i11 = i12;
                    }
                    i11 = Math.max(i7, i11);
                    i3 = i8;
                }
                i10 += m2648a(b, i10);
                obj5 = obj4;
                i8 = i3;
                i7 = i11;
                i12 = i6;
                i3 = i9;
                i11 = a;
                obj3 = obj7;
                f = f2;
            }
            i10++;
            i9 = i3;
            obj4 = obj5;
            obj2 = obj6;
            i6 = i11;
            i5 = i12;
        }
        if (this.f1278f > 0 && m2662c(virtualChildCount)) {
            this.f1278f += this.f1284l;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i10 = i5;
        } else {
            i10 = Math.max(i5, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f1278f = 0;
            i4 = 0;
            while (i4 < virtualChildCount) {
                View b2 = m2657b(i4);
                if (b2 == null) {
                    this.f1278f += m2663d(i4);
                    i3 = i4;
                } else if (b2.getVisibility() == 8) {
                    i3 = m2648a(b2, i4) + i4;
                } else {
                    c0563a = (C0563a) b2.getLayoutParams();
                    if (obj != null) {
                        this.f1278f = ((c0563a.rightMargin + (c0563a.leftMargin + i9)) + m2654b(b2)) + this.f1278f;
                        i3 = i4;
                    } else {
                        i11 = this.f1278f;
                        this.f1278f = Math.max(i11, (c0563a.rightMargin + ((i11 + i9) + c0563a.leftMargin)) + m2654b(b2));
                        i3 = i4;
                    }
                }
                i4 = i3 + 1;
            }
        }
        this.f1278f += getPaddingLeft() + getPaddingRight();
        int a2 = ag.m1258a(Math.max(this.f1278f, getSuggestedMinimumWidth()), i, 0);
        i4 = (16777215 & a2) - this.f1278f;
        int i16;
        if (obj4 != null || (i4 != 0 && f > 0.0f)) {
            if (this.f1279g > 0.0f) {
                f = this.f1279g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f1278f = 0;
            i9 = 0;
            float f3 = f;
            Object obj9 = obj2;
            i16 = i7;
            i15 = i6;
            i14 = i4;
            i7 = -1;
            while (i9 < virtualChildCount) {
                float f4;
                Object obj10;
                View b3 = m2657b(i9);
                if (b3 == null) {
                    f4 = f3;
                    i4 = i14;
                    i11 = i7;
                    i14 = i16;
                    obj10 = obj9;
                } else if (b3.getVisibility() == 8) {
                    f4 = f3;
                    i4 = i14;
                    i11 = i7;
                    i14 = i16;
                    obj10 = obj9;
                } else {
                    float f5;
                    c0563a = (C0563a) b3.getLayoutParams();
                    float f6 = c0563a.f1264g;
                    if (f6 > 0.0f) {
                        i4 = (int) ((((float) i14) * f6) / f3);
                        f3 -= f6;
                        i11 = i14 - i4;
                        i14 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + c0563a.topMargin) + c0563a.bottomMargin, c0563a.height);
                        if (c0563a.width == 0 && mode == 1073741824) {
                            if (i4 <= 0) {
                                i4 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i14);
                        } else {
                            i4 += b3.getMeasuredWidth();
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i14);
                        }
                        i8 = au.m3010a(i15, ag.m1285g(b3) & -16777216);
                        f5 = f3;
                    } else {
                        i11 = i14;
                        i8 = i15;
                        f5 = f3;
                    }
                    if (obj != null) {
                        this.f1278f += ((b3.getMeasuredWidth() + c0563a.leftMargin) + c0563a.rightMargin) + m2654b(b3);
                    } else {
                        i4 = this.f1278f;
                        this.f1278f = Math.max(i4, (((b3.getMeasuredWidth() + i4) + c0563a.leftMargin) + c0563a.rightMargin) + m2654b(b3));
                    }
                    obj5 = (mode2 == 1073741824 || c0563a.height != -1) ? null : 1;
                    i10 = c0563a.topMargin + c0563a.bottomMargin;
                    i14 = b3.getMeasuredHeight() + i10;
                    i7 = Math.max(i7, i14);
                    if (obj5 != null) {
                        i4 = i10;
                    } else {
                        i4 = i14;
                    }
                    i10 = Math.max(i16, i4);
                    obj5 = (obj9 == null || c0563a.height != -1) ? null : 1;
                    if (z) {
                        i12 = b3.getBaseline();
                        if (i12 != -1) {
                            i3 = ((((c0563a.f1265h < 0 ? this.f1277e : c0563a.f1265h) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i12);
                            iArr2[i3] = Math.max(iArr2[i3], i14 - i12);
                        }
                    }
                    f4 = f5;
                    i14 = i10;
                    obj10 = obj5;
                    i15 = i8;
                    i4 = i11;
                    i11 = i7;
                }
                i9++;
                i16 = i14;
                i7 = i11;
                obj9 = obj10;
                i14 = i4;
                f3 = f4;
            }
            this.f1278f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i7 = Math.max(i7, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj2 = obj9;
            i3 = i16;
            i6 = i15;
            i4 = i7;
        } else {
            i16 = Math.max(i7, i8);
            if (z2 && mode != 1073741824) {
                for (i4 = 0; i4 < virtualChildCount; i4++) {
                    View b4 = m2657b(i4);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((C0563a) b4.getLayoutParams()).f1264g <= 0.0f)) {
                        b4.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = i16;
            i4 = i10;
        }
        if (obj2 != null || mode2 == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension((-16777216 & i6) | a2, ag.m1258a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i6 << 16));
        if (obj3 != null) {
            m2646d(virtualChildCount, i);
        }
    }

    private void m2646d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m2657b(i3);
            if (b.getVisibility() != 8) {
                C0563a c0563a = (C0563a) b.getLayoutParams();
                if (c0563a.height == -1) {
                    int i4 = c0563a.width;
                    c0563a.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    c0563a.width = i4;
                }
            }
        }
    }

    int m2648a(View view, int i) {
        return 0;
    }

    int m2663d(int i) {
        return 0;
    }

    void m2653a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int m2647a(View view) {
        return 0;
    }

    int m2654b(View view) {
        return 0;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1276d == 1) {
            m2650a(i, i2, i3, i4);
        } else {
            m2659b(i, i2, i3, i4);
        }
    }

    void m2650a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.f1277e & 8388615;
        switch (this.f1277e & 112) {
            case 16:
                i5 = getPaddingTop() + (((i4 - i2) - this.f1278f) / 2);
                break;
            case 80:
                i5 = ((getPaddingTop() + i4) - i2) - this.f1278f;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View b = m2657b(i7);
            if (b == null) {
                i8 += m2663d(i7);
                i5 = i7;
            } else if (b.getVisibility() != 8) {
                int i9;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0563a c0563a = (C0563a) b.getLayoutParams();
                i5 = c0563a.f1265h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (C0325e.m1523a(i5, ag.m1283e(this)) & 7) {
                    case 1:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + c0563a.leftMargin) - c0563a.rightMargin;
                        break;
                    case 5:
                        i9 = (paddingRight - measuredWidth) - c0563a.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + c0563a.leftMargin;
                        break;
                }
                if (m2662c(i7)) {
                    i5 = this.f1285m + i8;
                } else {
                    i5 = i8;
                }
                int i10 = i5 + c0563a.topMargin;
                m2644a(b, i9, i10 + m2647a(b), measuredWidth, measuredHeight);
                i8 = i10 + ((c0563a.bottomMargin + measuredHeight) + m2654b(b));
                i5 = m2648a(b, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + 1;
        }
    }

    void m2659b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = au.m3012a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.f1277e & 8388615;
        int i8 = this.f1277e & 112;
        boolean z = this.f1273a;
        int[] iArr = this.f1281i;
        int[] iArr2 = this.f1282j;
        switch (C0325e.m1523a(i7, ag.m1283e(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f1278f) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f1278f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View b = m2657b(i10);
            if (b == null) {
                paddingLeft += m2663d(i10);
                i7 = i9;
            } else if (b.getVisibility() != 8) {
                int i11;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0563a c0563a = (C0563a) b.getLayoutParams();
                if (!z || c0563a.height == -1) {
                    i7 = -1;
                } else {
                    i7 = b.getBaseline();
                }
                int i12 = c0563a.f1265h;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & 112) {
                    case 16:
                        i11 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + c0563a.topMargin) - c0563a.bottomMargin;
                        break;
                    case 48:
                        i11 = paddingTop + c0563a.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[1] - i7;
                            break;
                        }
                        break;
                    case 80:
                        i11 = (paddingBottom - measuredHeight) - c0563a.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[2] - (b.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                if (m2662c(i10)) {
                    i7 = this.f1284l + paddingLeft;
                } else {
                    i7 = paddingLeft;
                }
                paddingLeft = i7 + c0563a.leftMargin;
                m2644a(b, paddingLeft + m2647a(b), i11, measuredWidth, measuredHeight);
                paddingLeft += (c0563a.rightMargin + measuredWidth) + m2654b(b);
                i7 = m2648a(b, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    private void m2644a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.f1276d != i) {
            this.f1276d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.f1276d;
    }

    public void setGravity(int i) {
        if (this.f1277e != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f1277e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.f1277e & 8388615) != i2) {
            this.f1277e = i2 | (this.f1277e & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f1277e & 112) != i2) {
            this.f1277e = i2 | (this.f1277e & -113);
            requestLayout();
        }
    }

    public C0563a mo519b(AttributeSet attributeSet) {
        return new C0563a(getContext(), attributeSet);
    }

    protected C0563a mo525j() {
        if (this.f1276d == 0) {
            return new C0563a(-2, -2);
        }
        if (this.f1276d == 1) {
            return new C0563a(-1, -2);
        }
        return null;
    }

    protected C0563a mo520b(LayoutParams layoutParams) {
        return new C0563a(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0563a;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(af.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(af.class.getName());
        }
    }
}
