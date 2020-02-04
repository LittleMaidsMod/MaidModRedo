package mmr.maidmodredo.client.maidmodel;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

import java.util.ArrayList;
import java.util.List;

public abstract class ModelBase<T extends LivingEntity> extends AbstractModelBase<T> {
	
	public static final float PI = (float)Math.PI;

	public LivingRenderer render;

	// ModelBaseとある程度互換
	public int textureWidth = 64;
	public int textureHeight = 32;
	public float onGrounds[] = new float[] {0.0F, 0.0F};
	public int dominantArm = 0;
	public boolean isRiding = false;
	public boolean isChild = true;
    public List<ModelRenderer> boxList = new ArrayList<ModelRenderer>();
	//カスタム設定
	public boolean motionSitting = false;

    public MaidModelAnimator animator = MaidModelAnimator.create();


	// ModelBase互換関数群

    public void render(IModelCaps pEntityCaps, MatrixStack matrixStack, IVertexBuilder iVertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha, boolean pIsRender) {
	}

	public void setRotationAngles(float par1, float par2, float pTicksExisted,
                                  float pHeadYaw, float pHeadPitch, IModelCaps pEntityCaps) {
	}

	public void setLivingAnimations(IModelCaps pEntityCaps, float par2, float par3, float pRenderPartialTicks) {
	}

	/*public ModelRenderer getRandomModelBox(Random par1Random) {
		return super.getRandomModelBox(par1Random);
	}*/


	// MathHelperトンネル関数群

	public static final float mh_sin(float f) {
		f = f % 6.283185307179586F;
		f = (f < 0F) ? 360 + f : f;
		return MathHelper.sin(f);
	}

	public static final float mh_cos(float f) {
		f = f % 6.283185307179586F;
		f = (f < 0F) ? 360 + f : f;
		return MathHelper.cos(f);
	}

	public static final float mh_sqrt(float f) {
		return MathHelper.sqrt(f);
	}

	public static final float mh_sqrt(double d) {
		return MathHelper.sqrt(d);
	}

	public static final int mh_floor(float f) {
		return MathHelper.floor(f);
	}

	public static final int mh_floor(double d) {
		return MathHelper.floor(d);
	}

	public static final long mh_floor_long(double d) {
		return MathHelper.floor(d);
	}

	public static final float mh_abs(float f) {
		return MathHelper.abs(f);
	}

	public static final double mh_abs_max(double d, double d1) {
		return MathHelper.absMax(d, d1);
	}

	public static final int mh_bucketInt(int i, int j) {
		return MathHelper.intFloorDiv(i, j);
	}

	public static final boolean mh_stringNullOrLengthZero(String s) {
		return s==null||s=="";
	}

	/*public static final int mh_getRandomIntegerInRange(Random random, int i, int j) {
		return MathHelper.getInt(random, i, j);
	}*/
}
