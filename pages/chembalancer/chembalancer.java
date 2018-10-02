package pages.chembalancer;

public class BalancerActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {
   public static final int TO_HTML_PARAGRAPH_LINES_INDIVIDUAL = 1;
   private Button btt0;
   private Button btt1;
   private Button btt2;
   private Button btt3;
   private Button btt4;
   private Button btt5;
   private Button btt6;
   private Button btt7;
   private Button btt8;
   private Button btt9;
   private Button bttAgAc;
   private Button bttAlAs;
   private Button bttArrow;
   private Button bttAuAt;
   private Button bttBaBe;
   private Button bttBalance;
   private Button bttBrBi;
   private Button bttCB;
   private Button bttCaCd;
   private Button bttClCs;
   private Button bttCloseBracket;
   private Button bttClr;
   private Button bttCoCe;
   private Button bttCrGa;
   private Button bttCuGe;
   private Button bttDel;
   private Button bttFHo;
   private Button bttFeIn;
   private Button bttHIr;
   private Button bttHeLa;
   private Button bttHgLu;
   private Button bttIMo;
   private Button bttKPd;
   private Button bttLiPt;
   private Button bttMgRh;
   private Button bttMnRb;
   private Button bttNRu;
   private Button bttNaSc;
   private Button bttNiSe;
   private Button bttOSr;
   private Button bttOpenBracket;
   private Button bttPTl;
   private Button bttPbTm;
   private Button bttPlus;
   private Button bttPtTi;
   private Button bttSV;
   private Button bttSiW;
   private Button bttSnY;
   private Button bttZnZr;
   String formatEquation = "";
   
   private DrawerLayout mDrawerLayout;
   private ActionBarDrawerToggle mToggle;
   String myMemory = null;
   NavigationView navigationView;
   private ToggleButton toggMore;
   private TextView txtResult;

   public static void addNum(ArrayList var0) {
      for(int var1 = 0; var1 < var0.size(); ++var1) {
         String var2 = (String)var0.get(var1);

         for(int var3 = 0; var3 < -1 + var2.length(); ++var3) {
            if(!Character.isDigit(var2.charAt(var3)) && var2.charAt(var3 + 1) == 41) {
               var2 = var2.substring(0, var3 + 1) + "1" + var2.substring(var3 + 1, var2.length());
               break;
            }

            if(Character.isUpperCase(var2.charAt(var3)) && !Character.isDigit(var2.charAt(var3 + 1)) && Character.isUpperCase(var2.charAt(var3 + 1))) {
               var2 = var2.substring(0, var3 + 1) + "1" + var2.substring(var3 + 1, var2.length());
            } else if(var3 == -2 + var2.length() && Character.isUpperCase(var2.charAt(var3 + 1))) {
               var2 = var2 + "1";
            }

            if(Character.isUpperCase(var2.charAt(var3)) && Character.isLowerCase(var2.charAt(var3 + 1))) {
               if(var3 != -2 + var2.length()) {
                  if(Character.isUpperCase(var2.charAt(var3 + 2)) || var2.charAt(var3 + 2) == 40) {
                     var2 = var2.substring(0, var3 + 2) + "1" + var2.substring(var3 + 2, var2.length());
                  }
               } else if(var3 == -2 + var2.length()) {
                  var2 = var2 + "1";
               }
            }
         }

         var0.set(var1, var2);
      }

   }

   private void addToProductsMatrix(ArrayList var1, double[][] var2, String[] var3, int var4) {
      int var5 = 0;
      int var6 = 0;

      for(int var7 = 0; var7 < var1.size(); ++var7) {
         String var8 = (String)var1.get(var7);
         ArrayList var9 = new ArrayList();
         ArrayList var10 = new ArrayList();
         this.patternMatchMatrix(var8, var9, var10);

         for(int var11 = 0; var11 < var9.size(); ++var11) {
            boolean var12 = false;

            for(int var13 = 0; var13 < var3.length; ++var13) {
               if(((String)var9.get(var11)).equals(var3[var13])) {
                  if(var7 + var4 == -1 + var2[0].length) {
                     var2[var13][var7 + var4] = (double)((Integer)var10.get(var11)).intValue();
                     var12 = true;
                  } else {
                     var2[var13][var7 + var4] = (double)(-1 * ((Integer)var10.get(var11)).intValue());
                     var12 = true;
                  }
               }
            }

            if(!var12) {
               if(var7 + var4 == -1 + var2[0].length) {
                  var2[var6][var7 + var4] = (double)((Integer)var10.get(var11)).intValue();
                  ++var6;
                  var3[var5] = (String)var9.get(var11);
                  ++var5;
               } else {
                  var2[var6][var7 + var4] = (double)(-1 * ((Integer)var10.get(var11)).intValue());
                  ++var6;
                  var3[var5] = (String)var9.get(var11);
                  ++var5;
               }
            }
         }
      }

   }

   private void addToReactantsMatrix(ArrayList var1, double[][] var2, String[] var3) {
      int var4 = 0;
      int var5 = 0;

      for(int var6 = 0; var6 < var1.size(); ++var6) {
         String var7 = (String)var1.get(var6);
         ArrayList var8 = new ArrayList();
         ArrayList var9 = new ArrayList();
         this.patternMatchMatrix(var7, var8, var9);
         if(var6 == 0) {
            for(int var13 = 0; var13 < var9.size(); ++var13) {
               var2[var5][var6] = (double)((Integer)var9.get(var13)).intValue();
               ++var5;
               var3[var4] = (String)var8.get(var13);
               ++var4;
            }
         } else {
            for(int var10 = 0; var10 < var8.size(); ++var10) {
               boolean var11 = false;

               for(int var12 = 0; var12 < var3.length; ++var12) {
                  if(((String)var8.get(var10)).equals(var3[var12])) {
                     var2[var12][var6] = (double)((Integer)var9.get(var10)).intValue();
                     var11 = true;
                  }
               }

               if(!var11) {
                  var2[var5][var6] = (double)((Integer)var9.get(var10)).intValue();
                  ++var5;
                  var3[var4] = (String)var8.get(var10);
                  ++var4;
               }
            }
         }
      }

   }

   public static void configureParenthesis(ArrayList var0) {
      label46:
      for(int var1 = 0; var1 < var0.size(); ++var1) {
         String var2 = (String)var0.get(var1);
         int var3 = var2.length();
         int var4 = 0;

         while(true) {
            while(true) {
               if(var4 >= -1 + var2.length()) {
                  continue label46;
               }

               if(var2.charAt(var4) == 40) {
                  int var5 = var2.indexOf(41);
                  Integer var6 = Integer.valueOf(Integer.parseInt(Character.toString(var2.charAt(var5 + 1))));

                  for(int var7 = var4 + 1; var7 < var5; ++var7) {
                     if(Character.isDigit(var2.charAt(var7))) {
                        Integer var11 = Integer.valueOf(Integer.parseInt(Character.toString(var2.charAt(var7))));
                        Integer var12 = Integer.valueOf(var11.intValue() * var6.intValue());
                        int var13 = var2.indexOf(var11.toString(), var7);
                        var2 = var2.substring(0, var13) + var12.toString() + var2.substring(var13 + 1, var2.length());
                        if(var2.length() > var3) {
                           var7 += var2.length() - var3;
                           var5 += var2.length() - var3;
                        }

                        var3 = var2.length();
                     }
                  }

                  if(var4 == 0) {
                     int var9 = var2.indexOf(41);
                     var0.set(var1, var2.substring(1, var9) + var2.substring(var9 + 2, var2.length()));
                  } else {
                     var0.set(var1, var2.substring(0, var4) + var2.substring(var4 + 1, var2.indexOf(41)));
                  }
               } else {
                  ++var4;
               }
            }
         }
      }

   }

   private boolean configureReDox(ArrayList var1, ArrayList var2) {
      boolean var3 = false;

      for(int var4 = 0; var4 < var1.size(); ++var4) {
         String var5 = (String)var1.get(var4);

         for(int var6 = 0; var6 < var5.length(); ++var6) {
            if(var6 == -1 + var5.length() && var5.charAt(var6) != 93) {
               var2.add(Double.valueOf(0.0D));
            }

            if(var5.charAt(var6) == 91) {
               var3 = true;
               var2.add(Double.valueOf(Double.parseDouble(var5.substring(var6 + 1, var5.indexOf(93)))));
               var5 = var5.substring(0, var6);
               break;
            }
         }

         var1.set(var4, var5);
      }

      return var3;
   }

   public static void converttoArrayList(String var0, ArrayList var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < var0.length(); ++var3) {
         if(var3 == -1 + var0.length()) {
            var1.add(var0.substring(var2, var0.length()));
         }

         if(Character.toString(var0.charAt(var3)).equals("+")) {
            String var4 = var0.substring(var2, var3);
            var2 = var3 + 1;
            var1.add(var4);
         }
      }

   }

   private String equationBalance(String param1) {
      // $FF: Couldn't be decompiled
   }

   private static int gcd(int var0, int var1) {
      while(var1 > 0) {
         int var2 = var1;
         var1 = var0 % var1;
         var0 = var2;
      }

      return var0;
   }

   private String generateFinalEquation(String[] var1, String[] var2, int[] var3) {
      int var4 = 0;
      String var5 = "";

      for(int var6 = 0; var6 < var1.length; ++var6) {
         if(var3[var4] == 1) {
            if(var6 == -1 + var1.length) {
               String var29 = var1[var6];
               String var30 = "";

               for(int var31 = 0; var31 < var29.length(); ++var31) {
                  if(Character.isDigit(var29.charAt(var31))) {
                     var30 = var30 + "<small>" + var29.charAt(var31) + "</small>";
                  } else {
                     var30 = var30 + var29.charAt(var31);
                  }
               }

               var5 = var5 + var30 + " → ";
            } else {
               String var26 = var1[var6];
               String var27 = "";

               for(int var28 = 0; var28 < var26.length(); ++var28) {
                  if(Character.isDigit(var26.charAt(var28))) {
                     var27 = var27 + "<small>" + var26.charAt(var28) + "</small>";
                  } else {
                     var27 = var27 + var26.charAt(var28);
                  }
               }

               var5 = var5 + var27 + " + ";
            }

            ++var4;
         } else {
            if(var6 == -1 + var1.length) {
               String var23 = var1[var6];
               String var24 = "";

               for(int var25 = 0; var25 < var23.length(); ++var25) {
                  if(Character.isDigit(var23.charAt(var25))) {
                     var24 = var24 + "<small>" + var23.charAt(var25) + "</small>";
                  } else {
                     var24 = var24 + var23.charAt(var25);
                  }
               }

               var5 = var5 + var3[var4] + var24 + " → ";
            } else {
               String var20 = var1[var6];
               String var21 = "";

               for(int var22 = 0; var22 < var20.length(); ++var22) {
                  if(Character.isDigit(var20.charAt(var22))) {
                     var21 = var21 + "<small>" + var20.charAt(var22) + "</small>";
                  } else {
                     var21 = var21 + var20.charAt(var22);
                  }
               }

               var5 = var5 + var3[var4] + var21 + " + ";
            }

            ++var4;
         }
      }

      for(int var7 = 0; var7 < var2.length; ++var7) {
         if(var3[var4] == 1) {
            if(var7 == -1 + var2.length) {
               String var17 = var2[var7];
               String var18 = "";

               for(int var19 = 0; var19 < var17.length(); ++var19) {
                  if(Character.isDigit(var17.charAt(var19))) {
                     var18 = var18 + "<small>" + var17.charAt(var19) + "</small>";
                  } else {
                     var18 = var18 + var17.charAt(var19);
                  }
               }

               var5 = var5 + var18;
            } else {
               String var14 = var2[var7];
               String var15 = "";

               for(int var16 = 0; var16 < var14.length(); ++var16) {
                  if(Character.isDigit(var14.charAt(var16))) {
                     var15 = var15 + "<small>" + var14.charAt(var16) + "</small>";
                  } else {
                     var15 = var15 + var14.charAt(var16);
                  }
               }

               var5 = var5 + var15 + " + ";
            }

            ++var4;
         } else {
            if(var7 == -1 + var2.length) {
               String var11 = var2[var7];
               String var12 = "";

               for(int var13 = 0; var13 < var11.length(); ++var13) {
                  if(Character.isDigit(var11.charAt(var13))) {
                     var12 = var12 + "<small>" + var11.charAt(var13) + "</small>";
                  } else {
                     var12 = var12 + var11.charAt(var13);
                  }
               }

               var5 = var5 + var3[var4] + var12;
            } else {
               String var8 = var2[var7];
               String var9 = "";

               for(int var10 = 0; var10 < var8.length(); ++var10) {
                  if(Character.isDigit(var8.charAt(var10))) {
                     var9 = var9 + "<small>" + var8.charAt(var10) + "</small>";
                  } else {
                     var9 = var9 + var8.charAt(var10);
                  }
               }

               var5 = var5 + var3[var4] + var9 + " + ";
            }

            ++var4;
         }
      }

      return var5;
   }

   public static int lcm(int var0, int var1) {
      return var0 * (var1 / gcd(var0, var1));
   }

   public static int lcm(int[] var0) {
      int var1 = var0[0];

      for(int var2 = 1; var2 < var0.length; ++var2) {
         var1 = lcm(var1, var0[var2]);
      }

      return var1;
   }

   public static CharSequence myCharsequence(String var0, int var1) {
      return VERSION.SDK_INT >= 24?Html.fromHtml(var0, var1):Html.fromHtml(var0);
   }

   private void patternMatch(ArrayList var1, ArrayList var2) {
      for(int var3 = 0; var3 < var1.size(); ++var3) {
         String var4 = (String)var1.get(var3);
         Matcher var5 = Pattern.compile("([A-Z])(\\d+)").matcher(var4);

         while(var5.find()) {
            if(!var2.contains(var5.group(1))) {
               var2.add(var5.group(1));
            }
         }

         Matcher var6 = Pattern.compile("([A-Z])([a-z])(\\d+)").matcher(var4);

         while(var6.find()) {
            if(!var2.contains(var6.group(1) + "" + var6.group(2))) {
               var2.add(var6.group(1) + "" + var6.group(2));
            }
         }

         Matcher var7 = Pattern.compile("([A-Z])([a-z])([a-z])(\\d+)").matcher(var4);

         while(var7.find()) {
            if(!var2.contains(var7.group(1) + "" + var7.group(2) + "" + var7.group(3))) {
               var2.add(var7.group(1) + "" + var7.group(2) + "" + var7.group(3));
            }
         }

         if(((String)var1.get(var3)).length() == 1) {
            var1.set(var3, (String)var1.get(var3) + "1");
         }
      }

   }

   private void patternMatchMatrix(String var1, ArrayList var2, ArrayList var3) {
      Matcher var4 = Pattern.compile("([A-Z])(\\d+)").matcher(var1);

      while(var4.find()) {
         if(var2.contains(var4.group(1))) {
            int var17 = var2.indexOf(var4.group(1));
            var3.set(var17, Integer.valueOf(((Integer)var3.get(var17)).intValue() + Integer.parseInt(var4.group(2))));
         } else {
            var2.add(var4.group(1));
            var3.add(Integer.valueOf(Integer.parseInt(var4.group(2))));
         }
      }

      Matcher var5 = Pattern.compile("([A-Z])([a-z])(\\d+)").matcher(var1);

      while(var5.find()) {
         if(var2.contains(var5.group(1) + "" + var5.group(2))) {
            int var13 = var2.indexOf(var5.group(1) + "" + var5.group(2));
            var3.set(var13, Integer.valueOf(((Integer)var3.get(var13)).intValue() + Integer.parseInt(var5.group(3))));
         } else {
            var2.add(var5.group(1) + "" + var5.group(2));
            var3.add(Integer.valueOf(Integer.parseInt(var5.group(3))));
         }
      }

      Matcher var6 = Pattern.compile("([A-Z])([a-z])([a-z])(\\d+)").matcher(var1);

      while(var6.find()) {
         if(var2.contains(var6.group(1) + "" + var6.group(2) + "" + var6.group(3))) {
            int var9 = var2.indexOf(var6.group(1) + "" + var6.group(2) + "" + var6.group(3));
            var3.set(var9, Integer.valueOf(((Integer)var3.get(var9)).intValue() + Integer.parseInt(var6.group(4))));
         } else {
            var2.add(var6.group(1) + "" + var6.group(2) + "" + var6.group(3));
            var3.add(Integer.valueOf(Integer.parseInt(var6.group(4))));
         }
      }

   }

  
   
   public static int toFraction(double var0) {
      int[] var2 = new int[13];
      int var3 = 0;

      for(int var4 = 0; var4 < 13; ++var4) {
         var2[var4] = (int)var0;
         var0 = 1.0D / (var0 - (double)var2[var4]);
      }

      int var5 = 0;

      while(var5 < 12) {
         int var6 = 1;
         var3 = 1;
         int var7 = 0;

         for(int var8 = var5; var8 >= 0; --var8) {
            var3 = var6;
            var6 = var7 + var6 * var2[var8];
            var7 = var3;
         }

         ++var5;
         if(Math.abs(var2[var5]) > 100) {
            break;
         }
      }

      return var3;
   }

   public static void toRREF(double[][] var0) {
      int var1 = var0.length;
      if(var1 != 0) {
         int var2 = var0[0].length;
         int var3 = 0;

         for(int var4 = 0; var4 < var1 && var3 < var2; ++var4) {
            int var5 = var4;

            while(var0[var5][var3] == 0.0D) {
               ++var5;
               if(var5 == var1) {
                  var5 = var4;
                  ++var3;
                  if(var3 == var2) {
                     return;
                  }
               }
            }

            double[] var6 = var0[var4];
            var0[var4] = var0[var5];
            var0[var5] = var6;
            double var7 = var0[var4][var3];

            for(int var9 = 0; var9 < var2; ++var9) {
               double[] var15 = var0[var4];
               var15[var9] /= var7;
            }

            for(int var10 = 0; var10 < var1; ++var10) {
               if(var10 != var4) {
                  double var11 = var0[var10][var3];

                  for(int var13 = 0; var13 < var2; ++var13) {
                     double[] var14 = var0[var10];
                     var14[var13] -= var11 * var0[var4][var13];
                  }
               }
            }

            ++var3;
         }
      }

   }

   

  

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2131361819);
      StartAppSDK.init(this, "201633929", true);
      StartAppAd.showSplash(this, var1);
      this.mAdView = (AdView)this.findViewById(2131230749);
      this.mAdView.loadAd((new Builder()).build());
      this.mInterstitialAd = new InterstitialAd(this);
      this.mInterstitialAd.setAdUnitId(this.getString(2131493038));
      this.RequestNewInterstitial();
      this.mDrawerLayout = (DrawerLayout)this.findViewById(2131230842);
      this.mToggle = new ActionBarDrawerToggle(this, this.mDrawerLayout, 2131493014, 2131492980);
      this.mDrawerLayout.addDrawerListener(this.mToggle);
      this.mToggle.syncState();
      this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      this.btt1 = (Button)this.findViewById(2131230762);
      this.btt2 = (Button)this.findViewById(2131230763);
      this.btt3 = (Button)this.findViewById(2131230764);
      this.btt4 = (Button)this.findViewById(2131230765);
      this.btt5 = (Button)this.findViewById(2131230766);
      this.btt6 = (Button)this.findViewById(2131230767);
      this.btt7 = (Button)this.findViewById(2131230768);
      this.btt8 = (Button)this.findViewById(2131230769);
      this.btt9 = (Button)this.findViewById(2131230770);
      this.btt0 = (Button)this.findViewById(2131230761);
      this.bttOpenBracket = (Button)this.findViewById(2131230803);
      this.bttCloseBracket = (Button)this.findViewById(2131230783);
      this.bttDel = (Button)this.findViewById(2131230787);
      this.bttClr = (Button)this.findViewById(2131230771);
      this.bttPlus = (Button)this.findViewById(2131230807);
      this.bttArrow = (Button)this.findViewById(2131230774);
      this.bttBalance = (Button)this.findViewById(2131230777);
      this.toggMore = (ToggleButton)this.findViewById(2131230975);
      this.bttAgAc = (Button)this.findViewById(2131230772);
      this.bttAlAs = (Button)this.findViewById(2131230773);
      this.bttAuAt = (Button)this.findViewById(2131230775);
      this.bttBaBe = (Button)this.findViewById(2131230776);
      this.bttBrBi = (Button)this.findViewById(2131230778);
      this.bttCB = (Button)this.findViewById(2131230779);
      this.bttCaCd = (Button)this.findViewById(2131230780);
      this.bttClCs = (Button)this.findViewById(2131230782);
      this.bttCoCe = (Button)this.findViewById(2131230784);
      this.bttCrGa = (Button)this.findViewById(2131230785);
      this.bttCuGe = (Button)this.findViewById(2131230786);
      this.bttFHo = (Button)this.findViewById(2131230788);
      this.bttFeIn = (Button)this.findViewById(2131230789);
      this.bttHIr = (Button)this.findViewById(2131230790);
      this.bttHeLa = (Button)this.findViewById(2131230791);
      this.bttHgLu = (Button)this.findViewById(2131230792);
      this.bttIMo = (Button)this.findViewById(2131230794);
      this.bttKPd = (Button)this.findViewById(2131230795);
      this.bttLiPt = (Button)this.findViewById(2131230796);
      this.bttMgRh = (Button)this.findViewById(2131230797);
      this.bttMnRb = (Button)this.findViewById(2131230798);
      this.bttNRu = (Button)this.findViewById(2131230799);
      this.bttNaSc = (Button)this.findViewById(2131230800);
      this.bttNiSe = (Button)this.findViewById(2131230801);
      this.bttOSr = (Button)this.findViewById(2131230802);
      this.bttPTl = (Button)this.findViewById(2131230804);
      this.bttPbTm = (Button)this.findViewById(2131230806);
      this.bttPtTi = (Button)this.findViewById(2131230808);
      this.bttSV = (Button)this.findViewById(2131230810);
      this.bttSiW = (Button)this.findViewById(2131230812);
      this.bttSnY = (Button)this.findViewById(2131230813);
      this.bttZnZr = (Button)this.findViewById(2131230814);
      this.txtResult = (TextView)this.findViewById(2131230964);
      this.btt1.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + "1";
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append("<small>1</small>").toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.btt2.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + "2";
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append("<small>2</small>").toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.btt3.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + "3";
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append("<small>3</small>").toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.btt4.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + "4";
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append("<small>4</small>").toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.btt5.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + "5";
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append("<small>5</small>").toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.btt6.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + "6";
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append("<small>6</small>").toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.btt7.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + "7";
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append("<small>7</small>").toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.btt8.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + "8";
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append("<small>8</small>").toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.btt9.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + "9";
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append("<small>9</small>").toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.btt0.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + "0";
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append("<small>0</small>").toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttClr.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = null;
            BalancerActivity.this.formatEquation = "";
            BalancerActivity.this.txtResult.setText("");
         }
      });
      this.bttDel.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(BalancerActivity.this.formatEquation.length() >= 9) {
               if(Character.isDigit(BalancerActivity.this.formatEquation.charAt(-9 + BalancerActivity.this.formatEquation.length()))) {
                  BalancerActivity.this.formatEquation = BalancerActivity.this.formatEquation.substring(0, -16 + BalancerActivity.this.formatEquation.length());
               } else {
                  BalancerActivity.this.formatEquation = BalancerActivity.this.formatEquation.substring(0, -1 + BalancerActivity.this.formatEquation.length());
               }

               BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText().toString().substring(0, -1 + BalancerActivity.this.txtResult.length());
            }

            if(BalancerActivity.this.formatEquation.length() > 0 && BalancerActivity.this.formatEquation.length() < 9) {
               BalancerActivity.this.formatEquation = BalancerActivity.this.formatEquation.substring(0, -1 + BalancerActivity.this.formatEquation.length());
               BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText().toString().substring(0, -1 + BalancerActivity.this.txtResult.getText().length());
            }

            if(BalancerActivity.this.formatEquation.length() == 0) {
               BalancerActivity.this.formatEquation = "";
               BalancerActivity.this.myMemory = null;
            }

            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttPlus.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + " + ";
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(" + ").toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttOpenBracket.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + "(";
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append("(").toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttCloseBracket.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + ")";
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(")").toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttArrow.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + " → ";
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(" → ").toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttAgAc.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttAgAc.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttAgAc.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttAlAs.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttAlAs.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttAlAs.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttAuAt.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttAuAt.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttAuAt.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttBaBe.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttBaBe.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttBaBe.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttBrBi.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttBrBi.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttBrBi.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttCB.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttCB.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttCB.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttCaCd.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttCaCd.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttCaCd.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttClCs.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttClCs.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttClCs.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttCoCe.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttCoCe.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttCoCe.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttCrGa.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttCrGa.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttCrGa.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttCuGe.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttCuGe.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttCuGe.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttFHo.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttFHo.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttFHo.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttFeIn.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttFeIn.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttFeIn.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttHIr.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttHIr.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttHIr.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttHeLa.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttHeLa.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttHeLa.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttHgLu.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttHgLu.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttHgLu.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttIMo.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttIMo.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttIMo.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttKPd.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttKPd.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttKPd.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttLiPt.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttLiPt.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttLiPt.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttMgRh.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttMgRh.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttMgRh.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttMnRb.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttMnRb.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttMnRb.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttNRu.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttNRu.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttNRu.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttNaSc.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttNaSc.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttNaSc.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttNiSe.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttNiSe.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttNiSe.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttOSr.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttOSr.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttOSr.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttPTl.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttPTl.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttPTl.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttPbTm.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttPbTm.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttPbTm.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttPtTi.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttPtTi.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttPtTi.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttSV.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttSV.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttSV.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttSiW.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttSiW.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttSiW.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttSnY.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttSnY.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttSnY.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttZnZr.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BalancerActivity.this.myMemory = BalancerActivity.this.txtResult.getText() + BalancerActivity.this.bttZnZr.getText().toString();
            StringBuilder var2 = new StringBuilder();
            BalancerActivity var3 = BalancerActivity.this;
            var3.formatEquation = var2.append(var3.formatEquation).append(BalancerActivity.this.bttZnZr.getText().toString()).toString();
            BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(BalancerActivity.this.formatEquation, 1), BufferType.SPANNABLE);
         }
      });
      this.bttBalance.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            String var2 = BalancerActivity.this.equationBalance(BalancerActivity.this.myMemory);
            if(var2 == null) {
               android.app.AlertDialog.Builder var3 = new android.app.AlertDialog.Builder(BalancerActivity.this);
               var3.setTitle(2131492892);
               var3.setMessage(2131492893);
               var3.setPositiveButton(2131492886, (android.content.DialogInterface.OnClickListener)null);
               var3.setCancelable(true);
               var3.create().show();
            } else {
               BalancerActivity.this.txtResult.setText(BalancerActivity.myCharsequence(var2, 1), BufferType.SPANNABLE);
            }
         }
      });
      this.toggMore.setOnClickListener(new OnClickListener() {
         int check = 1;

         public void onClick(View var1) {
            if(this.check == 1) {
               this.check = 0;
               BalancerActivity.this.bttAgAc.setText(2131492865);
               BalancerActivity.this.bttAlAs.setText(2131492869);
               BalancerActivity.this.bttAuAt.setText(2131492870);
               BalancerActivity.this.bttBaBe.setText(2131492876);
               BalancerActivity.this.bttBrBi.setText(2131492877);
               BalancerActivity.this.bttCB.setText(2131492872);
               BalancerActivity.this.bttCaCd.setText(2131492882);
               BalancerActivity.this.bttClCs.setText(2131492889);
               BalancerActivity.this.bttCoCe.setText(2131492883);
               BalancerActivity.this.bttCrGa.setText(2131492896);
               BalancerActivity.this.bttCuGe.setText(2131492897);
               BalancerActivity.this.bttFHo.setText(2131492901);
               BalancerActivity.this.bttFeIn.setText(2131492902);
               BalancerActivity.this.bttHIr.setText(2131492904);
               BalancerActivity.this.bttHeLa.setText(2131492906);
               BalancerActivity.this.bttHgLu.setText(2131492908);
               BalancerActivity.this.bttIMo.setText(2131492911);
               BalancerActivity.this.bttKPd.setText(2131492920);
               BalancerActivity.this.bttLiPt.setText(2131492922);
               BalancerActivity.this.bttMgRh.setText(2131492924);
               BalancerActivity.this.bttMnRb.setText(2131492923);
               BalancerActivity.this.bttNRu.setText(2131492925);
               BalancerActivity.this.bttNaSc.setText(2131492927);
               BalancerActivity.this.bttNiSe.setText(2131492928);
               BalancerActivity.this.bttOSr.setText(2131492931);
               BalancerActivity.this.bttPTl.setText(2131492933);
               BalancerActivity.this.bttPbTm.setText(2131492934);
               BalancerActivity.this.bttPtTi.setText(2131492932);
               BalancerActivity.this.bttSV.setText(2131492935);
               BalancerActivity.this.bttSiW.setText(2131492936);
               BalancerActivity.this.bttSnY.setText(2131492937);
               BalancerActivity.this.bttZnZr.setText(2131492940);
            } else if(this.check == 0) {
               this.check = 1;
               BalancerActivity.this.bttAgAc.setText(2131492867);
               BalancerActivity.this.bttAlAs.setText(2131492868);
               BalancerActivity.this.bttAuAt.setText(2131492871);
               BalancerActivity.this.bttBaBe.setText(2131492873);
               BalancerActivity.this.bttBrBi.setText(2131492878);
               BalancerActivity.this.bttCB.setText(2131492879);
               BalancerActivity.this.bttCaCd.setText(2131492880);
               BalancerActivity.this.bttClCs.setText(2131492885);
               BalancerActivity.this.bttCoCe.setText(2131492887);
               BalancerActivity.this.bttCrGa.setText(2131492888);
               BalancerActivity.this.bttCuGe.setText(2131492890);
               BalancerActivity.this.bttFHo.setText(2131492894);
               BalancerActivity.this.bttFeIn.setText(2131492895);
               BalancerActivity.this.bttHIr.setText(2131492898);
               BalancerActivity.this.bttHeLa.setText(2131492899);
               BalancerActivity.this.bttHgLu.setText(2131492900);
               BalancerActivity.this.bttIMo.setText(2131492903);
               BalancerActivity.this.bttKPd.setText(2131492905);
               BalancerActivity.this.bttLiPt.setText(2131492907);
               BalancerActivity.this.bttMgRh.setText(2131492909);
               BalancerActivity.this.bttMnRb.setText(2131492910);
               BalancerActivity.this.bttNRu.setText(2131492913);
               BalancerActivity.this.bttNaSc.setText(2131492914);
               BalancerActivity.this.bttNiSe.setText(2131492915);
               BalancerActivity.this.bttOSr.setText(2131492917);
               BalancerActivity.this.bttPTl.setText(2131492918);
               BalancerActivity.this.bttPbTm.setText(2131492919);
               BalancerActivity.this.bttPtTi.setText(2131492922);
               BalancerActivity.this.bttSV.setText(2131492926);
               BalancerActivity.this.bttSiW.setText(2131492929);
               BalancerActivity.this.bttSnY.setText(2131492930);
               BalancerActivity.this.bttZnZr.setText(2131492939);
               return;
            }

         }
      });
      
      this.navigationView = (NavigationView)this.findViewById(2131230896);
      this.navigationView.setNavigationItemSelectedListener(this);
   }

   public void onDestroy() {
      if(this.mAdView != null) {
         this.mAdView.destroy();
      }

      super.onDestroy();
   }

   public boolean onNavigationItemSelected(MenuItem var1) {
      switch(var1.getItemId()) {
      case 2131230859:
         this.startActivity(new Intent(this, HowToUseActivity.class));
         break;
      case 2131230860:
         this.startActivity(new Intent(this, BalancerActivity.class));
         break;
      case 2131230913:
         StartAppAd.showAd(this);
         break;
      case 2131230915:
         this.rateApp();
         break;
      case 2131230940:
         this.shareIt();
      }

      return true;
   }

   

   
      
   
}
